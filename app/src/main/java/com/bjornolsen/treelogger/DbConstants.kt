package com.yggdrasill.bjornolsen.discountcard

object DbConstants {
	const val TABLE_TREE = "Tree"
	const val TT_COL0 = "ID"
	const val TT_COL1 = "Number"
	const val TT_COL2 = "Height"
	const val TT_COL3 = "Width"

	const val CREATE_TABLE_TREE = ("CREATE TABLE ${DbConstants.TABLE_TREE} (${DbConstants.TT_COL0} INTEGER PRIMARY KEY AUTOINCREMENT, ${DbConstants.TT_COL1} INTEGER, ${DbConstants.TT_COL2} FLOAT, ${DbConstants.TT_COL3} FLOAT)")
}