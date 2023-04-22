package com.usergio.retos.retoapp.modelo.repositorio;
//importo el jpa para que me complete los datos de la bd como insert deletec etc

import com.usergio.retos.retoapp.modelo.entidad.Gama;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamaRepository extends JpaRepository <Gama,Long> {


}
