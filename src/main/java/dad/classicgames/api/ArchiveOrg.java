package dad.classicgames.api;

import dad.classicgames.api.model.ItemMetadata;
import dad.classicgames.api.model.Result;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArchiveOrg {

	private IArchiveOrg api;

	private ArchiveOrg() {

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://archive.org/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		api = retrofit.create(IArchiveOrg.class);

	}

	private void assertResponse(Response<?> response) throws Exception {
		if (!response.isSuccessful()) {
			throw new Exception(response.errorBody().string());
		}
	}

	public Result getGames(Integer count, String cursor) throws Exception {
		System.out.println("getGames: count=" + count + ", cursor=" + cursor);
		Response<Result> response = api.scrape("title,logo,description,year", count, cursor, "softwarelibrary_msdos_games").execute();
		assertResponse(response);
		return response.body();
	}

	public Result searchGames(Integer count, String cursor, String search) throws Exception {
		System.out.println("searchGames: count=" + count + ", cursor=" + cursor + ", search=" + search);
		Response<Result> response = api.scrape("title,logo,description,year", count, cursor, "collection:(softwarelibrary_msdos_games) AND title:(" + search + ")").execute();
		assertResponse(response);
		return response.body();
	}

	public ItemMetadata getItemMetadata(String id) throws Exception {
		System.out.println("getItemMetadata: id=" + id);
		Response<ItemMetadata> response = api.getMetadata(id).execute();
		assertResponse(response);
		return response.body();
	}

	// singleton

	private static ArchiveOrg instance;

	public static ArchiveOrg getInstance() {
		if (instance == null) {
			instance = new ArchiveOrg();
		}
		return instance;
	}

}
