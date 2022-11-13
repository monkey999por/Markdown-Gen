package app.monkey999.creater;

public class CreatorFactory {
    public static Creator getInstance(CreatorName name){
        Creator instance = switch (name) {
            case Java -> new Java();
            case javascript -> new Javascript();
            case PHP -> new PHP();
            case Powershell -> new Powershell();
            case nextjs -> new Nextjs();
            case html -> new Html();
            case css -> new Css();
            case nomal -> new Nomal();
        };
        return instance;
    }
}
