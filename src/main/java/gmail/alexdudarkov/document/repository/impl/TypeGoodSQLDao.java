package gmail.alexdudarkov.document.repository.impl;

import gmail.alexdudarkov.document.repository.AbstractSQLDao;
import gmail.alexdudarkov.document.repository.exception.DAOException;
import gmail.alexdudarkov.document.repository.model.TypeGood;

import java.util.List;



public class TypeGoodSQLDao  extends AbstractSQLDao<TypeGood> {
	public TypeGoodSQLDao(Class<TypeGood> typeParameterClass) {
		super(typeParameterClass);
	}

	@Override
	public List<TypeGood> getByExample(TypeGood object) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
}
