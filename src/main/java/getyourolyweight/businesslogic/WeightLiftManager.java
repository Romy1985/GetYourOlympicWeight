package getyourolyweight.businesslogic;

import getyourolyweight.datastorage.AtleteDAO;
import getyourolyweight.domain.Atlete;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by r.ceuleers on 29-9-2016.
 */
public class WeightLiftManager {
    private final Map<String, Atlete> atletes;

    public WeightLiftManager() {
        atletes = new HashMap<>();
    }
    public Atlete findAtlete(String email) {
        Atlete atlete = atletes.get(email);

        if (atlete == null ) {
            AtleteDAO atleteDAO = new AtleteDAO();
            atlete = atleteDAO.findAtlete(email);

            atletes.put(email, atlete);


    }
        return atlete;
}

}


