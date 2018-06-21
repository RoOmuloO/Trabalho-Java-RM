package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Consulta;
import model.ReceitaHasMedicamento;
import model.ReceitaPK;
import model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-18T18:34:51")
@StaticMetamodel(Receita.class)
public class Receita_ { 

    public static volatile SingularAttribute<Receita, String> horaVenda;
    public static volatile SingularAttribute<Receita, Short> cancelada;
    public static volatile SingularAttribute<Receita, String> dataVenda;
    public static volatile SingularAttribute<Receita, Short> usada;
    public static volatile SingularAttribute<Receita, String> instrucao;
    public static volatile SingularAttribute<Receita, Usuario> usuario;
    public static volatile SingularAttribute<Receita, ReceitaPK> receitaPK;
    public static volatile SingularAttribute<Receita, Consulta> consulta;
    public static volatile ListAttribute<Receita, ReceitaHasMedicamento> receitaHasMedicamentoList;

}