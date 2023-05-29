

function calcularvalortotalPorProducto(){
    let total = 0;
    let vueltos = 0;
    for (let i =1 ; i<=3;i++) {
        let cantidad = parseInt(document.getElementById("cantidad"+i).value)||1,
        valunidad = parseInt(document.getElementById("valorUnidad"+i).value)||0;
    
        let resultado = cantidad*valunidad;
        total += resultado;

        document.getElementById("valtotal"+i).value= resultado;   

    }
    let pago = parseInt(document.getElementById("pago").value)||0;
    document.getElementById("vueltos").value= pago-total;
    document.getElementById("total").value=total;
}