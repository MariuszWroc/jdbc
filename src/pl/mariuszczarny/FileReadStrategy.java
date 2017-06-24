package pl.mariuszczarny;

import static pl.mariuszczarny.util.AppProperties.STATMEMENT_PATH;

import java.util.List;

import pl.mariuszczarny.file.ReadFile;


public class FileReadStrategy implements QueringStrategy{

	@Override
	public List<String> readyFrom() {
		ReadFile file = new ReadFile();
		return file.read(STATMEMENT_PATH.getValue());
	}

}
