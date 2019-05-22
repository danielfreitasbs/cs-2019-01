function raizQuadrada(radicando, precisao) {

    if (Number.isNaN(radicando) || Number.isNaN(precisao)) {
        throw new TypeError("Valor informado não é um numero");
    }
    if (radicando === null || radicando === undefined || precisao === null || precisao === undefined) {
        throw new TypeError("Valor informado não definido");
    }
    if (!Number.isInteger(radicando) || !Number.isInteger(precisao)) {
        throw new TypeError("Valores devem ser inteiros");
    }
    if (radicando <= 0) {
        throw new RangeError("Radicando informado inválido. Valor informado: " + radicando);
    }

    let iteradorPrecisao = precisao;

    var raizQuadrada = 1;
    for (iteradorPrecisao; iteradorPrecisao >= 0; iteradorPrecisao--) {
        raizQuadrada = (raizQuadrada + radicando / raizQuadrada) / 2;
    }

    return raizQuadrada;
}