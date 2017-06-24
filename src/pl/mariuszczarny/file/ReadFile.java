package pl.mariuszczarny.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class ReadFile {
	private static Logger LOGGER = Logger.getLogger(ReadFile.class.getName());

	public List<String> read(String path) {
		List<String> queries = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			stream.forEach(item -> {
				queries.add(item);
				LOGGER.log(Level.INFO, "Query: " + item);
			});
		} catch (IOException e) {
			LOGGER.log(Level.WARNING, "Reading file failed. " + e.getMessage(), e);
		}

		return queries;
	}
}
