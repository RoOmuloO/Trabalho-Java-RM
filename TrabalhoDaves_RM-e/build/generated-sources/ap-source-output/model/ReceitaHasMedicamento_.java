package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Dosagem;
import model.Medicamento;
import model.Receita;
import model.ReceitaHasMedicamentoPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-18T18:34:51")
@StaticMetamodel(ReceitaHasMedicamento.class)
public class ReceitaHasMedicamento_ { 

    public static volatile SingularAttribute<ReceitaHasMedicamento, Receita> receita;
    public static volatile SingularAttribute<ReceitaHasMedicamento, ReceitaHasMedicamentoPK> receitaHasMedicamentoPK;
    public static volatile SingularAttribute<ReceitaHasMedicamento, Medicamento> medicamento;
    public static volatile SingularAttribute<ReceitaHasMedicamento, Short> vendido;
    public static volatile SingularAttribute<ReceitaHasMedicamento, Dosagem> dosagem;

}