package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.ReceitaHasMedicamento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-18T18:34:51")
@StaticMetamodel(Dosagem.class)
public class Dosagem_ { 

    public static volatile SingularAttribute<Dosagem, String> horario;
    public static volatile SingularAttribute<Dosagem, String> frequencia;
    public static volatile SingularAttribute<Dosagem, Integer> iddosagem;
    public static volatile SingularAttribute<Dosagem, String> meio;
    public static volatile ListAttribute<Dosagem, ReceitaHasMedicamento> receitaHasMedicamentoList;

}