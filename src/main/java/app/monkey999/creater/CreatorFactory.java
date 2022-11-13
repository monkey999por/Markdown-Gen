package app.monkey999.creater;

public class CreatorFactory {
    public static Creator getInstance(CreatorName name){
        Creator instance = switch (name) {
            case Java -> null;
            case javascript -> new Javascript();
            case PHP -> null;
            case Powershell -> null;
            case nextjs -> null;
            case html -> null;
            case css -> null;
        };
        return instance;
    }
}
