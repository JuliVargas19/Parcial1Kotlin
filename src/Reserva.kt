open class Reserva (
    val idReserva: Int,
    val idHuespedes: Int,
    var nombreHuesped: String,
    var emailHuesped: String,
    val numeroHabitacion: Int,
    val tipoHabitacion: String,
    var precioPorNoche: Double,
    var cantidadNochesReservadas: Int
){
    fun montoTotal(): Double{
        return precioPorNoche * cantidadNochesReservadas
    }
}

