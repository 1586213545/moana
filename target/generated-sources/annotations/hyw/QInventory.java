package hyw;

import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

public class QInventory extends PersistableExpressionImpl<Inventory> implements PersistableExpression<Inventory>
{
    public static final QInventory jdoCandidate = candidate("this");

    public static QInventory candidate(String name)
    {
        return new QInventory(null, name, 5);
    }

    public static QInventory candidate()
    {
        return jdoCandidate;
    }

    public static QInventory parameter(String name)
    {
        return new QInventory(Inventory.class, name, ExpressionType.PARAMETER);
    }

    public static QInventory variable(String name)
    {
        return new QInventory(Inventory.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression name;
    public final CollectionExpression products;

    public QInventory(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.name = new StringExpressionImpl(this, "name");
        this.products = new CollectionExpressionImpl(this, "products");
    }

    public QInventory(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.name = new StringExpressionImpl(this, "name");
        this.products = new CollectionExpressionImpl(this, "products");
    }
}
