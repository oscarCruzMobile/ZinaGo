import UIKit
import SwiftUI
import Shared

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Self.Context)  -> UIViewController {
        let controller = MainViewControllerKt.MainViewController()
        
        // Aquí forzamos el color de fondo base del controlador
        // Cambia 'systemBackground' por el color que uses en tu app
        controller.view.backgroundColor = UIColor.systemBackground
        
        return controller
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Self.Context) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView()
            .ignoresSafeArea()
    }
}
