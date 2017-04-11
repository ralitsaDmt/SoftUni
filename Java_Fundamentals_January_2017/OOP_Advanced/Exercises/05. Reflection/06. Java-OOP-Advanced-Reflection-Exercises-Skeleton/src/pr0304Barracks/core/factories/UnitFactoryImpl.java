package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.models.units.Archer;
import pr0304Barracks.models.units.Pikeman;
import pr0304Barracks.models.units.Swordsman;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		String classFullName = UNITS_PACKAGE_NAME + unitType;
		Class unitClass = Class.forName(classFullName);
		Unit instance = (Unit) unitClass.newInstance();
		return instance;
	}
}
