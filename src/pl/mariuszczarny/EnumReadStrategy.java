package pl.mariuszczarny;

import java.util.ArrayList;
import java.util.List;

import pl.mariuszczarny.util.SqlQuery;

public class EnumReadStrategy implements QueringStrategy{

	@Override
	public List<String> readyFrom() {
		List<String> enumQueries = new ArrayList<>();
		enumQueries.add(SqlQuery.CREATE.getQuery());
		return enumQueries;
	}

}
