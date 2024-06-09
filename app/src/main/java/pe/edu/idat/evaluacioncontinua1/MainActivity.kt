package pe.edu.idat.evaluacioncontinua1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ejercicio 1: Jubilación
        val edadInput = findViewById<EditText>(R.id.edadInput)
        val sexoInput = findViewById<EditText>(R.id.sexoInput)
        val calcularJubilacionButton = findViewById<Button>(R.id.calcularJubilacionButton)
        val resultadoJubilacion = findViewById<TextView>(R.id.resultadoJubilacion)

        calcularJubilacionButton.setOnClickListener {
            val edad = edadInput.text.toString().toInt()
            val sexo = sexoInput.text.toString()
            val resultado = puedeJubilarse(edad, sexo)
            resultadoJubilacion.text = resultado
        }

        // Ejercicio 2: Menor de cuatro números
        val numero1Input = findViewById<EditText>(R.id.numero1Input)
        val numero2Input = findViewById<EditText>(R.id.numero2Input)
        val numero3Input = findViewById<EditText>(R.id.numero3Input)
        val numero4Input = findViewById<EditText>(R.id.numero4Input)
        val calcularMenorButton = findViewById<Button>(R.id.calcularMenorButton)
        val resultadoMenor = findViewById<TextView>(R.id.resultadoMenor)

        calcularMenorButton.setOnClickListener {
            val numero1 = numero1Input.text.toString().toInt()
            val numero2 = numero2Input.text.toString().toInt()
            val numero3 = numero3Input.text.toString().toInt()
            val numero4 = numero4Input.text.toString().toInt()
            val menor = menorDeCuatro(numero1, numero2, numero3, numero4)
            resultadoMenor.text = "El menor es: $menor"
        }

        // Ejercicio 3: Costo de matrícula
        val materiasInput = findViewById<EditText>(R.id.materiasInput)
        val calcularMatriculaButton = findViewById<Button>(R.id.calcularMatriculaButton)
        val resultadoMatricula = findViewById<TextView>(R.id.resultadoMatricula)

        calcularMatriculaButton.setOnClickListener {
            val materias = materiasInput.text.toString().toInt()
            val costo = calcularMatricula(materias)
            resultadoMatricula.text = "El costo de la matrícula es: S/ $costo"
        }

        // Ejercicio 4: Cuadrado y mitad
        val calcularCuadradoMitadButton = findViewById<Button>(R.id.calcularCuadradoMitadButton)
        val resultadoCuadradoMitad = findViewById<TextView>(R.id.resultadoCuadradoMitad)

        calcularCuadradoMitadButton.setOnClickListener {
            calcularCuadradoYMitad(resultadoCuadradoMitad)
        }
    }

    fun puedeJubilarse(edad: Int, sexo: String): String {
        return if ((sexo.equals("Hombre", ignoreCase = true) && edad >= 60) ||
            (sexo.equals("Mujer", ignoreCase = true) && edad >= 54)) {
            "Ya puede jubilarse"
        } else {
            "Aún no puede jubilarse"
        }
    }

    fun menorDeCuatro(a: Int, b: Int, c: Int, d: Int): Int {
        return minOf(a, b, c, d)
    }

    fun calcularMatricula(materias: Int): Double {
        val costoPorMateria = 520.0
        val total = materias * costoPorMateria
        return if (materias > 5) {
            total * 0.9
        } else {
            total
        }
    }

    fun calcularCuadradoYMitad(resultadoTextView: TextView) {
        val resultado = StringBuilder()
        for (numero in 15..70) {
            val cuadrado = numero * numero
            val mitad = numero / 2.0
            resultado.append("Número: $numero, Cuadrado: $cuadrado, Mitad: $mitad\n")
        }
        resultadoTextView.text = resultado.toString()
    }
}