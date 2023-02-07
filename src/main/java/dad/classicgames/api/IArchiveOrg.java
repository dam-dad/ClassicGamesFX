package dad.classicgames.api;

import dad.classicgames.api.model.ItemMetadata;
import dad.classicgames.api.model.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IArchiveOrg {
	
	@GET("services/search/v1/scrape")
	Call<Result> scrape(@Query("fields") String fields, @Query("q") String query);

	@GET("metadata/{id}")
	Call<ItemMetadata> getMetadata(@Path("id") String id);
	
}
