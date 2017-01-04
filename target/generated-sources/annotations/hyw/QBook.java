package hyw;

import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

public class QBook extends hyw.QProduct
{
    public static final QBook jdoCandidate = candidate("this");

    public static QBook candidate(String name)
    {
        return new QBook(null, name, 5);
    }

    public static QBook candidate()
    {
        return jdoCandidate;
    }

    public static QBook parameter(String name)
    {
        return new QBook(Book.class, name, ExpressionType.PARAMETER);
    }

    public static QBook variable(String name)
    {
        return new QBook(Book.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression author;
    public final StringExpression isbn;
    public final StringExpression publisher;

    public QBook(PersistableExpression parent, String name, int depth)
    {
        super(parent, name, depth);
        this.author = new StringExpressionImpl(this, "author");
        this.isbn = new StringExpressionImpl(this, "isbn");
        this.publisher = new StringExpressionImpl(this, "publisher");
    }

    public QBook(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.author = new StringExpressionImpl(this, "author");
        this.isbn = new StringExpressionImpl(this, "isbn");
        this.publisher = new StringExpressionImpl(this, "publisher");
    }
}
