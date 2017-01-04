package hyw;

import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

public class QProduct extends PersistableExpressionImpl<Product> implements PersistableExpression<Product>
{
    public static final QProduct jdoCandidate = candidate("this");

    public static QProduct candidate(String name)
    {
        return new QProduct(null, name, 5);
    }

    public static QProduct candidate()
    {
        return jdoCandidate;
    }

    public static QProduct parameter(String name)
    {
        return new QProduct(Product.class, name, ExpressionType.PARAMETER);
    }

    public static QProduct variable(String name)
    {
        return new QProduct(Product.class, name, ExpressionType.VARIABLE);
    }

    public final NumericExpression<Long> id;
    public final StringExpression name;
    public final StringExpression description;
    public final NumericExpression<Double> price;

    public QProduct(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.id = new NumericExpressionImpl<Long>(this, "id");
        this.name = new StringExpressionImpl(this, "name");
        this.description = new StringExpressionImpl(this, "description");
        this.price = new NumericExpressionImpl<Double>(this, "price");
    }

    public QProduct(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.id = new NumericExpressionImpl<Long>(this, "id");
        this.name = new StringExpressionImpl(this, "name");
        this.description = new StringExpressionImpl(this, "description");
        this.price = new NumericExpressionImpl<Double>(this, "price");
    }
}
