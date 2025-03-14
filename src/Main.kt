fun main() {
    val reservas = mutableListOf<Reserva>()

    while (true){
        println("1. Registrar una reserva:")
        println("2. Cancelar una reserva:")
        println("3. Mostrar todas las reservas activas:")
        println("4. Salir..")
        println("Selecciona una opcion:")

        when (readLine()?.toIntOrNull()){
            1 -> {
            println("Id de reserva:")
            val idReserva = readLine()?.toIntOrNull() ?: return
            println("Id de Huésped")
            val idHuesped = readLine()?.toIntOrNull() ?: return
            print("Nombre huésped: ")
            val nombreHuesped = readLine().orEmpty()
            print("Email huésped: ")
            val emailHuesped = readLine().orEmpty()
            print("Número de habitación: ")
            val numeroHabitacion = readLine()?.toIntOrNull() ?: return
            print("Tipo de habitación: ")
            val tipoHabitacion = readLine().orEmpty()
            print("Precio por noche: ")
            val precioPorNoche = readLine()?.toDoubleOrNull() ?: return
            print("Cantidad de noches reservadas: ")
            val cantidadNochesReservadas = readLine()?.toIntOrNull() ?: return

            if (reservas.any { it.numeroHabitacion == numeroHabitacion }) {
                println("Error: La habitación $numeroHabitacion ya está reservada.")
            } else {
                val reserva = Reserva(idReserva, idHuesped, nombreHuesped, emailHuesped,numeroHabitacion, tipoHabitacion, precioPorNoche, cantidadNochesReservadas)
                    reservas.add(reserva)
                    println("Su reserva se ha registrado exitosamente.")
                }
            } 2 -> {
            print("Ingrese el ID de la reserva para cancelar: ")
            val idCancelar = readLine()?.toIntOrNull()
            if (idCancelar != null) {
                val reservaEliminada = reservas.removeIf { it.idReserva == idCancelar }
                if (reservaEliminada) println("Su reserva se cancelo exitosamente")
                else println("Id invalido no se encuentra su reserva")
            } else {
                println("ID no encontrado")
            }
        } 3 -> {
            if (reservas.isEmpty()) {
                println(" No hay reservas activas")
                } else {
                    println("\n---- Reservas Activas ----")
                    reservas.forEach {
                        println(
                            "ID: ${it.idReserva},  Habitación: ${it.numeroHabitacion}," + " Huésped: ${it.nombreHuesped},  Total: ${it.precioPorNoche * it.cantidadNochesReservadas}"
                        )
                    }
                }
            }

            4 -> {
                println("Saliendo...")
                break
            }

            else -> println("Opción inválida, intente otra vez")
        }
    }
}
