package ext;

import dao.IDao;

public class DaoImplVWS implements IDao {
    @Override
    public double getData() {
        System.out.println("Vesion web service");
        return 90;
    }
}
