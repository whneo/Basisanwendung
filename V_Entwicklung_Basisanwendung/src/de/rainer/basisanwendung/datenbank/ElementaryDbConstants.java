package de.rainer.basisanwendung.datenbank;

public abstract class ElementaryDbConstants {
	
	final String CLASS_NAME = "org.sqlite.JDBC";
	final String DB_PATH = "datenbank/";
	final String DB_NAME = "ElementarySchool.sqlite";
	final String CONNECTION = "jdbc:sqlite:" + this.DB_PATH
			+ this.DB_NAME;
	final String DDL_FILE = "ElementarySchool_DDL_ohneWortlisten.sql";
	final String DML_FILE = "ElementarySchool_DML_ohneWortlisten.sql";

}
