package it.polito.tdp.rivers.db;

import it.polito.tdp.rivers.model.River;

public class TestRiversDAO {

	public static void main(String[] args) {
		RiversDAO dao = new RiversDAO();
		System.out.println(dao.getAllRivers());
		System.out.println(dao.getFlows(new River(1,"Tevere")));
	}

}
