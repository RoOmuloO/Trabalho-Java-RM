package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.ReceitaHasMedicamento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-18T18:34:51")
@StaticMetamodel(Medicamento.class)
public class Medicamento_ { 

    public static volatile SingularAttribute<Medicamento, String> tipo;
    public static volatile SingularAttribute<Medicamento, String> manipuladoura;
    public static volatile SingularAttribute<Medicamento, Integer> idmedicamento;
    public static volatile SingularAttribute<Medicamento, String> nome;
    public static volatile SingularAttribute<Medicamento, String> vendido;
    public static volatile ListAttribute<Medicamento, ReceitaHasMedicamento> receitaHasMedicamentoList;
    public static volatile SingularAttribute<Medicamento, String> descricao;

}