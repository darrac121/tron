}

import java.util.Scanner;


class Player {
          
    // Constants
    private static final String UP = "UP";
    private static final String DOWN = "DOWN";
    private static final String LEFT = "LEFT";
    private static final String RIGHT = "RIGHT";
    private static final  String[] directions = new String[]{UP,LEFT,DOWN,RIGHT};
    private static final int X = 30;
    private static final int Y = 20;
    
    // Map
    public static int[][] Grille = new int[X][Y];
    
    // Nombre de joueur
    public static int nbPlayer;
    
    // Id du joueur
    public static int idPlayer;
    
    // la position des joueurs
    public static Position[] players;
    
    /**
     * Play an action
     */
    private static void action(final String direction){
        System.out.println(direction);
    }
    
    /**
     * Debug a message
     */
    private static void debug(final String message){
         System.err.println(message);
    }

    /**
     * Main player class
     * //@param args 
     */
    public static void main(final String args[]) {
       
        // Init the scanner
        final Scanner in = new Scanner(System.in);

        // Init coordinates
        int x0, y0, x1, y1;
 
        // Initialize the checkerBoard
        removePlayer(0);

        // Infinite while ...
        while (true) {
            
            // NB joueur
            nbPlayer = in.nextInt();
            System.err.println(nbPlayer);
            // position joueurs
            if (players == null){
                players = new Position[nbPlayer];
                for(int i = 0; i < nbPlayer; i++){
                    players[i] = new Position(0,0);
                }
            }
            
            // Id du joueur
            idPlayer = in.nextInt();
            System.err.println(idPlayer);
    
            // For each players
            for (int player = 0; player < nbPlayer; player++){
            
                // coordonnée
                x0 = in.nextInt();
                y0 = in.nextInt();
                x1 = in.nextInt();
                y1 = in.nextInt();
                System.err.println(x0);
                System.err.println(y0);
                System.err.println(x1);
                System.err.println(y1);
                // joueur perdu
                if (x0 == -1){
                    removePlayer(player);
                    continue;
                }
                
                // mis a jour de la grille
                Grille[x1][y1] = player;
                //int ab[i]=x1;
                //int co[i]=y1;
                
                
                // sauvegarde la place du joueur actuelle
                players[player].update(x1,y1);
            }

            
            play();
            
        }
    }

    
    /** 
     * 
     */
    private static void removePlayer(final int id){
        for(int i=0; i<Grille.length;i++){
            for (int e = 0; e < Grille[i].length;e++){
                if (Grille[i][e]  ==  id ) {
                    Grille[i][e] = -1;
                }
            }
        }
    }
 
    /**
     * Play a round 
     */
    public static void play(){
        
         

        action(LEFT);
       
    }
    
    /**
     * Position class
     */
    public static class Position{
        public int x;
        public int y;
        public boolean me;
        
        /** Constructor */
         public Position(final int x, final int y){
             this.x = x;
             this.y = y;
         }
         
         /** Update the position */
         public void update(final int x, final int y){
             this.x = x;
             this.y = y;
         }
         
        /* (non-Javadoc)
         * @see java.lang.Object#equals(java.lang.Object)
         */
        public boolean equals(final Position obj) {
            return (obj != null && obj.x == x && obj.y == y);
        }
    }
 }