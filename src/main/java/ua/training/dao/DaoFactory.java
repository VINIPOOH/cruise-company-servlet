package ua.training.dao;


import ua.training.dao.impl.JDBCDaoFactory;
import ua.training.persistance.ConnectionPoolHolder;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new JDBCDaoFactory(ConnectionPoolHolder.pool());
                }
            }
        }
        return daoFactory;
    }

    public abstract UserDao createUserDao();

    public abstract CruiseDao createCruiseDao();

    public abstract OrderDao createOrderDao();

    public abstract TicketDao createTicketDao();

    public abstract ExcursionDao createExcursionDao();
}
