
package Model;

import java.time.LocalDateTime;


public class CalendarioSistema {
    
    private LocalDateTime dataHoraSistema = LocalDateTime.of(2023, 1, 1, 8, 0, 0);
    

    public LocalDateTime getDataHoraSistema() {
        return dataHoraSistema;
    }

    public void setDataHoraSistema(LocalDateTime dataHoraSistema) {
        this.dataHoraSistema = dataHoraSistema;
    }
    
    public boolean passaDias(int dias)
    {
        this.setDataHoraSistema(dataHoraSistema.plusDays(dias));
        return false;
    }
    
}
