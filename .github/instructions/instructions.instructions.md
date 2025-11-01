---
applyTo: '**'
---
Provide project context and coding guidelines that AI should follow when generating code, answering questions, or reviewing changes.

1. **Arquitectura**
   - Usar arquitectura **MVVM con Repository**.
   - No colocar lógica de negocio en Fragments ni Activities.
   - ViewModels manejan datos; Repository accede a la base de datos Room.

2. **Base de Datos**
   - Implementar **Room** con entidades, DAO y base de datos singleton.
   - Todas las operaciones de base de datos deben ser `suspend`.
   - No usar SQL directo ni librerías externas de persistencia.

3. **Corrutinas**
   - Todas las operaciones asíncronas deben usar **Kotlin Coroutines**.
   - Emplear `viewModelScope.launch` o `Dispatchers.IO` para tareas en segundo plano.
   - Prohibido usar `AsyncTask`, `Thread`, `Executor` o `Handler`.

4. **Navegación y Fragments**
   - Toda la app debe usar **Navigation Component**.
   - La navegación entre pantallas se define en `nav_graph.xml`.
   - El `startDestination` es `LoginFragment`.

5. **Login y Autenticación**
   - Implementar **BiometricPrompt** para autenticación por huella.
   - Mostrar ventana emergente con título, subtítulo y botón cancelar antes de iniciar la autenticación.
   - Si la autenticación es correcta → navegar al inventario.
   - Si falla → mostrar mensaje de error.
   - Guardar estado de sesión en `SharedPreferences` o `SessionManager`.

6. **Interfaz**
   - Usar **Fragments**, no Activities múltiples.
   - Sin `ActionBar` o `Toolbar` visibles en los Fragments.
   - Animaciones dinámicas con **Lottie** en formato JSON dentro de `res/raw/`.

7. **Buenas Prácticas**
   - Clases y funciones deben estar en inglés.
   - Seguir principio de responsabilidad única.
   - Todos los textos visibles deben provenir de `strings.xml`.
   - Usar `Log.d()` en lugar de `println`.
   - Evitar duplicación de código.

8. **Sesión**
   - `SessionManager` controla el estado de inicio de sesión.
   - Si el usuario ya está autenticado, saltar el `LoginFragment`.

9. **Restricciones Copilot**
   - No generar código fuera del patrón MVVM.
   - No usar Activities para lógica o navegación.
   - No incluir dependencias no autorizadas.
   - No insertar lógica de negocio en UI.
   - No ignorar corrutinas ni Room.

