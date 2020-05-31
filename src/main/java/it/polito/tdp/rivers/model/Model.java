package it.polito.tdp.rivers.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
	private RiversDAO dao = new RiversDAO();
	private Map<Integer, River> riverMap = new HashMap<Integer, River>();

	public List<River> getAllRivers() {
		return dao.getAllRivers();
	}

	public void getInfoRiver(River river) {
		int riverId = river.getId();
		if (!riverMap.containsKey(riverId)) {
			List<Flow> f = dao.getFlows(river);
			river.setFlows(f);
			river.setFirstDate(f.get(0).getDay());
			river.setLastDate(f.get(f.size() - 1).getDay());
			river.setTotalMeasure(f.size());
			float media = 0;
			for (Flow fl : f) {
				media += fl.getFlow();
			}
			media /= f.size();
			river.setMedianMeasure(media);
			riverMap.put(riverId, river);
		}
	}

	public String simula(River river, int k) {
		List<Flow> flows = river.getFlows(); // Lista acqua in ingresso
		float Q = k * river.getMedianMeasure() * 30; // Capienza totale bacino idrico (30 = giorni)
		float C = Q / 2; // Acqua presente nel bacino idrico (metà del totale)
		float Cmed = 0; // Media acqua nel bacino
		int noFmin = 0; // Totale giorni NO erogazione minima
		float Fmin = 0.8f * river.getMedianMeasure(); // Uscita minima del bacino
		int irr = 0; // Totale irrigazioni

		for (Flow f : flows) {
			// Ingresso acqua nel bacino
			C += f.getFlow();
			// Controllo tracimazione
			if (C > Q) {
				C = Q;
			}
			// Uscita acqua dal bacino
			if (Math.random() < 0.5) {
				C -= Fmin * 10;
				irr++;
			} else {
				C -= Fmin;
			}
			// Controllo bacino vuoto
			if (C <= 0) {
				C = 0;
				noFmin++;
			}
			// Aggiungi C per creare la media del bacino idrico
			Cmed += C;
//			System.out.println(C);
		}
		return "Occupazione media bacino: " + (Cmed / flows.size()) + "\nTotale giorni serbatoio vuoto: " + noFmin
				+ "\nIrrigazioni totali: " + irr;
	}

}
