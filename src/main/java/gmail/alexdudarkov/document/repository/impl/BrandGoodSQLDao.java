package gmail.alexdudarkov.document.repository.impl;

import gmail.alexdudarkov.document.repository.AbstractSQLDao;
import gmail.alexdudarkov.document.repository.exception.DAOException;
import gmail.alexdudarkov.document.repository.model.BrandGood;

import java.util.List;



public class BrandGoodSQLDao extends AbstractSQLDao<BrandGood> {
public  BrandGoodSQLDao(Class<BrandGood> typeParameterClass){
	super(typeParameterClass);
}

@Override
public List<BrandGood> getByExample(BrandGood object) throws DAOException {
	// TODO Auto-generated method stub
	return null;
}
}
