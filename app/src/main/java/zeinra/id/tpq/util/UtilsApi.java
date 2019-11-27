package zeinra.id.tpq.util;

public class UtilsApi {

    public static final String BASE_URL_API = "http://rocky-savannah-87206.herokuapp.com/api/auth/user/";

    //Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService()
    {
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
