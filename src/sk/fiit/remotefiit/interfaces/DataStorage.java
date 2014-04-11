package sk.fiit.remotefiit.interfaces;

import java.util.Map;

import sk.fiit.remotefiit.app.Movement;

public interface DataStorage {
		Map readData();
		void storeData(Map<String,Map<Movement,Integer>> mapa);
}
