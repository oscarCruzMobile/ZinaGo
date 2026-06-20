import SwiftUI
import Shared

@main
struct iOSApp: App {
    init() {
        // La función es initKoin, por lo tanto el objeto es KoinKt.initKoin
        // Como tu función tiene un parámetro opcional 'appDeclaration',
        // debes pasarle el bloque vacío si no vas a inyectar nada específico desde iOS.
        KoinHelper.shared.doInitKoin(appDeclaration: { _ in })
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}