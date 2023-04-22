package com.usergio.retos.retoapp.modelo.repositorio;
//importo el jpa para que me complete los datos de la bd como insert deletec etc


import com.usergio.retos.retoapp.modelo.entidad.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository <Message,Long> {


}
