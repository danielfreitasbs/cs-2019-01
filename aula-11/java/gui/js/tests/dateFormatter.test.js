const formatadorData = require("../dateFormatter");

test("Formata dia correto", ()=>{
    expect("20", formatadorData.dataFormatter.formataDiaOuMes("20"));
});

test("Formata mes correto", ()=>{
    expect("12", formatadorData.dataFormatter.formataDiaOuMes("12"));
});

test("Valor nulo formataDiaOuMes", () =>{
    expect(() =>{formatadorData.formataDiaOuMes(null)}).throw(TypeError);
});

test("Valor undefined formataDiaOuMes", () =>{
    let undefinedArg;
    expect(() =>{formatadorData.formataDiaOuMes(undefinedArg)}).throw(TypeError);
});

test("Valor vazio formataDiaOuMes", () =>{
    expect(() =>{formatadorData.formataDiaOuMes("")}).throw(RangeError);
});

test("Formata ano correto", ()=>{
    expect("2019", formatadorData.dataFormatter.formataAno("2019"));
});

test("Valor nulo formataAno", () =>{
    expect(() =>{formatadorData.formataAno(null)}).throw(TypeError);
});

test("Valor undefined formataAno", () =>{
    let undefinedArg;
    expect(() =>{formatadorData.formataAno(undefinedArg)}).throw(TypeError);
});

test("Valor vazio formataAno", () =>{
    expect(() =>{formatadorData.formataAno("")}).throw(RangeError);
});

test("Formata data correto", ()=>{
    expect("11-07-2019", formatadorData.dataFormatter.formataData("2019-07-11"));
});


test("Valor nulo formataData", () =>{
    expect(() =>{formatadorData.formataData(null)}).throw(TypeError);
});

test("Valor undefined formataDiaOuMes", () =>{
    let undefinedArg;
    expect(() =>{formatadorData.formataData(undefinedArg)}).throw(TypeError);
});

test("Valor vazio formataDiaOuMes", () =>{
    expect(() =>{formatadorData.formataData("")}).throw(RangeError);
});

