package dad.classicgames.api;

import dad.classicgames.api.model.ItemMetadata;
import dad.classicgames.api.model.Result;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArchiveOrg {

	private IArchiveOrg api;

	public ArchiveOrg() {

		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://archive.org/")
				.addConverterFactory(GsonConverterFactory.create()).build();

		api = retrofit.create(IArchiveOrg.class);

	}

	private void assertResponse(Response<?> response) throws Exception {
		if (!response.isSuccessful()) {
			throw new Exception(response.errorBody().string());
		}
	}

	public Response<Result> getGames(String count,String cursor) throws Exception {
		Response<Result> response = api.scrape("title,logo,description,year", count,cursor, "softwarelibrary_msdos_games").execute();
		assertResponse(response);
		return response;
	}
	

	public ItemMetadata getItemMetadata(String id) throws Exception {
		Response<ItemMetadata> response = api.getMetadata(id).execute();
		assertResponse(response);
		return response.body();
	}

}
