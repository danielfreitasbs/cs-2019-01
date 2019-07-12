const formatadorData = require("../dateFormatter");

test("Formata dia correto", ()=>{
    expect("20", formatadorData.dataFormatter.formataDiaOuMes("20"));
});

test("Formata mes correto", ()=>{
    expect("12", formatadorData.dataFormatter.formataDiaOuMes("12"));
});
