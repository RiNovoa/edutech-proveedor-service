package com.edutech.proveedor.util;

import com.edutech.proveedor.model.Proveedor;

import net.datafaker.Faker;

public class ProveedorTestUtils {

    private static final Faker faker = new Faker();

    public static Proveedor crearProveedorFake() {
        Proveedor p = new Proveedor();
        p.setNombre(faker.company().name());
        return p;
    }
}
