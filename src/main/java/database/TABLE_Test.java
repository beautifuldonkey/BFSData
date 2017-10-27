package database;

import javax.persistence.*;
import java.io.Serializable;


@NamedQueries({
    @NamedQuery(name = "getRecords", query = "FROM TABLE_Test ")
})

@Entity
@Table(name = "TEST")
public class TABLE_Test implements Serializable{

  @Id
  @Column(name = "ID")
  private int id;

  @Column(name = "COL1")
  private String col1;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCol1() {
    return col1;
  }

  public void setCol1(String col1) {
    this.col1 = col1;
  }
}
