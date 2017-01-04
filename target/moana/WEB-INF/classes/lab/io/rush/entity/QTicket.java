package lab.io.rush.entity;

import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

public class QTicket extends PersistableExpressionImpl<Ticket> implements PersistableExpression<Ticket>
{
    public static final QTicket jdoCandidate = candidate("this");

    public static QTicket candidate(String name)
    {
        return new QTicket(null, name, 5);
    }

    public static QTicket candidate()
    {
        return jdoCandidate;
    }

    public static QTicket parameter(String name)
    {
        return new QTicket(Ticket.class, name, ExpressionType.PARAMETER);
    }

    public static QTicket variable(String name)
    {
        return new QTicket(Ticket.class, name, ExpressionType.VARIABLE);
    }

    public final NumericExpression<Long> id;
    public final StringExpression name;

    public QTicket(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.id = new NumericExpressionImpl<Long>(this, "id");
        this.name = new StringExpressionImpl(this, "name");
    }

    public QTicket(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.id = new NumericExpressionImpl<Long>(this, "id");
        this.name = new StringExpressionImpl(this, "name");
    }
}
