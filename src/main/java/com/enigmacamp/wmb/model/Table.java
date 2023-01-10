package com.enigmacamp.wmb.model;

import com.enigmacamp.wmb.enums.Availability;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@javax.persistence.Table(name = "tables")
public class Table {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "table_id")
    private String tableId;

    @Column(name = "table_number", nullable = false, length = 50, unique = true)
    private String tableNumber;

    @Column(name = "table_status", nullable = false)
    private Availability tableStatus;
}
