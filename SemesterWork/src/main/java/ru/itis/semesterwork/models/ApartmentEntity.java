package ru.itis.semesterwork.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "apartment")
public class ApartmentEntity extends AbstractEntity {

    private Long price;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;
}
