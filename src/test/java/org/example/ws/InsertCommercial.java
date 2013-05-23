package org.example.ws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.ws.bean.Commercial;
import org.example.ws.bean.PhoneNumber;
import org.example.ws.dao.CommercialDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InsertCommercial {
	public static Logger logger = Logger.getLogger(InsertCommercial.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream(new File("commercial.xls"));
			Workbook wb = new HSSFWorkbook(is);
			List<OneRow> result = new ArrayList<InsertCommercial.OneRow>();
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				Sheet st = wb.getSheetAt(i);
				result.addAll(handleSheet(st));
			}
			System.out.println(result.size());
			System.out.println(result.get(0).getComm());
			insertCommercial(result);

		} catch (FileNotFoundException e) {
			logger.info("file is not found!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void insertCommercial(List<OneRow> result) {
		ApplicationContext act = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CommercialDao commercialDao = (CommercialDao) act
				.getBean("commercialDao");
		SessionFactory sessionFactory = (SessionFactory) act
				.getBean("sessionFactory");
		for (OneRow oneRow : result) {
			Commercial c = oneRow.getComm();
			commercialDao.save(c);
			Session session;
			List<PhoneNumber> pn = oneRow.getPhone();
			for (PhoneNumber p : pn) {
				p.setComm_id(c.getCommId());
				Transaction tx = null;
				session = sessionFactory.openSession();
				try {
					tx = session.beginTransaction();
					session.save(p);
					tx.commit();
				} catch (HibernateException he) {
					if (tx != null)
						tx.rollback();
					throw he;
				} finally {
					session.close();
				}
			}
		}
	}

	public static class OneRow {
		private Commercial comm;
		private List<PhoneNumber> phone;

		public OneRow() {

		}

		public Commercial getComm() {
			return comm;
		}

		public void setComm(Commercial comm) {
			this.comm = comm;
		}

		public List<PhoneNumber> getPhone() {
			return phone;
		}

		public void setPhone(List<PhoneNumber> phone) {
			this.phone = phone;
		}
	}

	public static List<OneRow> handleSheet(Sheet st) {
		int firstRowNum = st.getFirstRowNum();
		int lastRowNum = st.getLastRowNum();
		int rowNum = st.getPhysicalNumberOfRows();
		List<OneRow> result = null;
		logger.info("firstRowNum=" + firstRowNum + "lastRowNum=" + lastRowNum
				+ "totalRowNum=" + rowNum);
		if (rowNum != 0) {
			int firstColNum = st.getRow(firstRowNum).getFirstCellNum();
			int lastColNum = st.getRow(firstRowNum).getLastCellNum();
			logger.info("firstColNum=" + firstColNum + "lastColNum="
					+ lastColNum);
			Row firstRow = st.getRow(firstRowNum);
			int colNum = 0;
			for (int i = firstColNum; i < lastColNum; i++) {
				if (firstRow.getCell(i) != null) {
					System.out.println(i + ":"
							+ firstRow.getCell(i).getStringCellValue());
					colNum++;
				}
			}
			logger.info("有效列为" + colNum);
			result = new ArrayList<OneRow>(colNum);

			for (int i = firstRowNum + 1; i < lastRowNum; i++) {
				// logger.info("current row:" + i);
				Row row = st.getRow(i);
				if (row.getCell(firstColNum) == null
						|| row.getCell(firstColNum).getStringCellValue()
								.equals("")) {
					// logger.info("name is null, pass this row " + i);
					continue;
				} else {
					logger.info(row.getCell(firstColNum).getStringCellValue());

				}
				OneRow oneRow = new OneRow();
				List<PhoneNumber> pn = new ArrayList<PhoneNumber>();
				oneRow.setPhone(pn);
				Commercial comm = new Commercial();
				for (int j = firstColNum; j < colNum; j++) {
					Cell cell = row.getCell(j);
					if (cell == null)
						continue;
					if (firstRow.getCell(j).getStringCellValue()
							.equalsIgnoreCase("名称")) {
						comm.setName(cell.getStringCellValue());
					} else if (firstRow.getCell(j).getStringCellValue()
							.equalsIgnoreCase("商圈")) {
						String[] reg = cell.getStringCellValue().split("、");
						comm.setRegion1(reg[0]);
						comm.setRegion2(reg[1]);
					} else if (firstRow.getCell(j).getStringCellValue()
							.equalsIgnoreCase("类别")) {
						comm.setKind1("美食");
						comm.setKind2(cell.getStringCellValue());
					} else if (firstRow.getCell(j).getStringCellValue()
							.equalsIgnoreCase("预算")) {
						if (cell != null)
							comm.setBudget((int) cell.getNumericCellValue());
					} else if (firstRow.getCell(j).getStringCellValue()
							.equalsIgnoreCase("营业时间")) {
						String s = cell.getStringCellValue();
						String[] s1 = s.split(" ");
						String open = "", close = "";
						int i1 = 0;
						for (String ss : s1) {
							if (i1 > 0)
								break;
							String[] s2 = ss.split("-");
							open += s2[0] + ";";
							close += s2[1] + ";";
							i1++;
						}
						comm.setOpentime(open);
						comm.setClosetime(close);
					} else if (firstRow.getCell(j).getStringCellValue()
							.equalsIgnoreCase("地址")) {
						comm.setAddress(cell.getStringCellValue());
					} else if (firstRow.getCell(j).getStringCellValue()
							.indexOf("电话") != -1) {
						if (cell != null) {

							String content = "";
							if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								content = ""
										+ new BigDecimal(
												cell.getNumericCellValue());
							} else {
								content = cell.getStringCellValue();
							}
							if (content.equals("")) {
								continue;
							}
							content = content.replace("\n", " ");
							String[] cs = content.split(" ");
							System.out.println(Arrays.toString(cs));
							for (String ss : cs) {
								System.out.println(ss);
								PhoneNumber ppn = new PhoneNumber();
								ppn.setPhone_num(ss);
								String s = firstRow.getCell(j)
										.getStringCellValue();
								if (s.indexOf("（") != -1) {
									// logger.info(s.substring(s.indexOf("（")));
									ppn.setPhone_desc(s.substring(s
											.indexOf("（")));
								}
								pn.add(ppn);
							}

						}
					} else if (firstRow.getCell(j).getStringCellValue()
							.equalsIgnoreCase("能否刷卡")) {
						if (cell.getStringCellValue().equalsIgnoreCase("Y")) {
							comm.setIsCardSupported(true);
						} else {
							comm.setIsCardSupported(false);
						}
					} else if (firstRow.getCell(j).getStringCellValue()
							.equalsIgnoreCase("能否吸烟")) {
						if (cell.getStringCellValue().equalsIgnoreCase("Y")) {
							comm.setIsSmokeEnable(true);
						} else {
							comm.setIsSmokeEnable(false);
						}
					} else if (firstRow.getCell(j).getStringCellValue()
							.equalsIgnoreCase("能否讲日语")) {
						if (cell.getStringCellValue().equalsIgnoreCase("Y")) {
							comm.setIsJapanese(true);
						} else {
							comm.setIsJapanese(false);
						}
					} else if (firstRow.getCell(j).getStringCellValue()
							.equalsIgnoreCase("能否开发票")) {
						if (cell.getStringCellValue().equalsIgnoreCase("Y")) {
							comm.setIsIvoiceSupported(true);
						} else {
							comm.setIsIvoiceSupported(false);
						}
					} else if (firstRow.getCell(j).getStringCellValue()
							.equalsIgnoreCase("有包间否")) {
						if (cell.getStringCellValue().equalsIgnoreCase("Y")) {
							comm.setIsPrivateRoomEnabled(true);
						} else {
							comm.setIsPrivateRoomEnabled(false);
						}
					} else if (firstRow.getCell(j).getStringCellValue()
							.equalsIgnoreCase("是否有wifi")) {
						if (cell.getStringCellValue().equalsIgnoreCase("Y")) {
							comm.setIsWifiSupported(true);
						} else {
							comm.setIsWifiSupported(false);
						}
					} else if (firstRow.getCell(j).getStringCellValue()
							.equalsIgnoreCase("经度")) {
						if (cell != null)
							comm.setLongitude(cell.getNumericCellValue());
					} else if (firstRow.getCell(j).getStringCellValue()
							.equalsIgnoreCase("纬度")) {
						if (cell != null)
							comm.setLatitude(cell.getNumericCellValue());
					}

				}
				if (comm != null) {
					oneRow.setComm(comm);
					result.add(oneRow);
				}
			}
		}
		return result;
	}
}
