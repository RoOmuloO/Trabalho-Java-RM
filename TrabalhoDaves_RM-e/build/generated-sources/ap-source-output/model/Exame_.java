package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Consulta;
import model.ExamePK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-18T18:34:51")
@StaticMetamodel(Exame.class)
public class Exame_ { 

    public static volatile SingularAttribute<Exame, String> tipo;
    public static volatile SingularAttribute<Exame, ExamePK> examePK;
    public static volatile SingularAttribute<Exame, Consulta> consulta;
    public static volatile SingularAttribute<Exame, String> descricao;

}