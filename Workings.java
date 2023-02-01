/*
@file Workings.java
@brief this program implements all of the other classes to make the game actually work, using if and else if statements alongside the other classes
       to print out cards and go through every single possiblity when it comes to the action the users could take within the game. The bcf
       variable is used with scanner and the .equals command to take in the action the user wants to take, and the bet1 and bet2 variables track
       how much total has been bet, then being output to the users so they can keep track of this as well.
@author Cameron Doyle
@data November 29th, 2022
 */
//This is the extended extended class.
import java.util.Scanner;
public class Workings {
    public String bcf;          //Field variable bcf used with scanner to see if user wants to bet, check, or fold
    public int bet1 = 0;
    public int bet2 = 0;                    //Bet amounts initialized to zero
    //create two different methods or create two separate classes
    Scanner scnr = new Scanner(System.in);
    Players players = new Players();            //Creates players object
    //public void betCheck(){



    public void Bet() {             //Used alongside program class for if player 1 bets on first turn, method was too large to have everything all in one
        bcf = "bet";
        if (bcf.equals("bet")) {
            System.out.println("Player one has bet one.");
            bet1 = 1;
            System.out.println("Would player two like to raise, call, or fold? (input raise, call, or fold)");
            bcf = scnr.next();

            //If else statements used alongside bet variables and bcf variables to track what users would like to do for every single possibility within the game.
            if (bcf.equals("call")) {
                bet2 = 1;
                System.out.println("Player two calls the pot is now " + (bet1 + bet2));
                players.makeFlop();     //Players object used with methods within the class to make the threee card flop, and later on the turn and river
                System.out.println("Player one would you like to check or bet? (input check, bet)");
                bcf = scnr.next();

                //post flop
                if (bcf.equals("bet")) {
                    bet1 = 2;
                    System.out.println("Player one has bet one.");
                    System.out.println("Would player two like to raise, call or fold? (input (raise, call, or fold)");
                    bcf = scnr.next();
                    if (bcf.equals("fold")) {
                        System.out.println("Player two has folded, player one wins the hand.");
                    } else if (bcf.equals("call")) {
                        bet2 = 2;
                        System.out.println("Player two has called, the pot is now " + (bet1 + bet2) + " and the turn is...");
                        players.makeTurn();
                        System.out.println("Player one would you like to check or bet?");
                        bcf = scnr.next();
                        if (bcf.equals("bet")) {
                            bet1 = 3;
                            System.out.println("Player one has bet, would player two like to call, raise or fold?");
                            bcf = scnr.next();
                            if (bcf.equals("call")) {
                                bet2 = 3;
                                System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                players.makeRiver();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 4;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 4;
                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 5;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 5;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 4;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 4;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 5;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    }
                                }
                            } else if (bcf.equals("raise")) {
                                bet2 = 4;
                                System.out.println("Player two has raised, would player one like to call or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet1 = 4;
                                    System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 5;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 5;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 6;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 6;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 5;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 6;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player one has folded, player two wins!");
                                }
                            }
                        } else if (bcf.equals("check")) {
                            System.out.println("Player one has checked, would player two like to check or bet?");
                            bcf = scnr.next();
                            if (bcf.equals("check")) {
                                System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                players.makeRiver();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 3;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 3;
                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 4;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 4;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 3;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 3;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 4;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    }
                                }
                            } else if (bcf.equals("bet")) {
                                bet2 = 3;
                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet1 = 3;
                                    System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                } else if (bcf.equals("raise")) {
                                    bet1 = 4;
                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        System.out.println("Player two has called the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 5;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 6;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 5;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player one has folded, player two wins!");
                                }
                            }
                        }
                    } else if (bcf.equals("raise")) {
                        System.out.println("Player two has raised. Would player one like to call or fold?");
                        bet2 = 3;
                        bcf = scnr.next();
                        if (bcf.equals("fold")) {
                            System.out.println("Player one has folded, player two wins!");
                        } else if (bcf.equals("call")) {
                            bet1 = 3;
                            System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                            players.makeTurn();
                            System.out.println("Would player one like to bet or check?");
                            bcf = scnr.next();
                            if (bcf.equals("bet")) {
                                bet1 = 4;
                                System.out.println("Player one has bet, would player two like to call, fold, or raise?");
                                bcf = scnr.next();
                                if (bcf.equals("fold")) {
                                    System.out.println("Player two has folded, player one wins!");
                                } else if (bcf.equals("call")) {
                                    bet2 = 4;
                                    System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 5;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 5;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 6;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 6;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 5;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 6;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("raise")) {
                                    bet2 = 5;
                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 5;
                                        System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 6;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 6;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 7;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 7;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 6;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 7;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 7;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                }
                            } else if (bcf.equals("check")) {
                                bet1 = 3;
                                bet2 = 3;
                                System.out.println("Player one has checked, would player two like to check or bet?");
                                bcf = scnr.next();
                                if (bcf.equals("check")) {
                                    System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 4;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 5;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 4;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 5;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("bet")) {
                                    bet2 = 4;
                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 4;
                                        System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 5;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 6;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 5;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("raise")) {
                                        bet1 = 5;
                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 5;
                                            System.out.println("Player two has called the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 6;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 7;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 7;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                }
                            }
                        }
                    }
                } else if (bcf.equals("check")) {
                    System.out.println("Player one has checked, would player two like to check or bet?");
                    bcf = scnr.next();
                    if (bcf.equals("check")) {
                        System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                        players.makeTurn();
                        System.out.println("Would player one like to check or bet?");
                        bcf = scnr.next();
                        if (bcf.equals("check")) {
                            System.out.println("Player one has checked, would player two like to bet or check?");
                            bcf = scnr.next();
                            if (bcf.equals("bet")) {
                                bet2 = 2;
                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                if (bcf.equals("call")) {
                                    bet1 = 2;
                                    System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 3;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 3;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 4;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 3;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 3;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 4;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 4;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("raise")) {
                                    bet1 = 3;
                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 3;
                                        System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 4;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 5;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 4;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 4;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 5;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player one has folded, player two wins!");
                                }
                            } else if (bcf.equals("check")) {
                                System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                players.makeRiver();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 2;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 2;
                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 3;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 3;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 2;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 2;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 3;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 3;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    }
                                }
                            }
                        } else if (bcf.equals("bet")) {
                            bet1 = 2;
                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                            bcf = scnr.next();
                            if (bcf.equals("call")) {
                                bet2 = 2;
                                System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                players.makeRiver();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 3;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 3;
                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 4;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 4;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 3;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 3;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 4;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    }
                                }
                            } else if (bcf.equals("raise")) {
                                bet2 = 3;
                                System.out.println("Player two has raised, would player one like to call or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet1 = 3;
                                    System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 4;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 5;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 4;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 5;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player one has folded, player two wins!");
                                }
                            } else if (bcf.equals("fold")) {
                                System.out.println("Player two has folded, player one wins!");
                            }
                        }
                    } else if (bcf.equals("bet")) {
                        bet2 = 2;
                        System.out.println("Player two has bet, would player one like to raise, call or fold?");
                        bcf = scnr.next();
                        if (bcf.equals("call")) {
                            bet1 = 2;
                            System.out.println("Player one has called the pot is now " + (bet1 + bet2));
                            players.makeTurn();
                            System.out.println("Would player one like to bet or check?");
                            bcf = scnr.next();
                            if (bcf.equals("bet")) {
                                bet1 = 3;
                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet2 = 3;
                                    System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 4;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 5;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 4;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 5;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("raise")) {
                                    bet2 = 4;
                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 4;
                                        System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 5;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 6;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 5;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins! ");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player two has folded, player one wins!");
                                }
                            } else if (bcf.equals("check")) {
                                System.out.println("Player one has checked, would player two like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet2 = 3;
                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 3;
                                        System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 4;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 5;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 4;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 4;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 5;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("raise")) {
                                        bet1 = 4;
                                        System.out.println("Player one has raise, would player two like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 5;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 5;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 6;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 3;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 3;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 4;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 3;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 3;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 4;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 4;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                }
                            }

                        } else if (bcf.equals("fold")) {
                            System.out.println("Player one folds, player two wins!");
                        } else if (bcf.equals("raise")) {
                            bet1 = 3;
                            System.out.println("Player one raises, would player two like to call or fold?");
                            bcf = scnr.next();
                            if (bcf.equals("fold")) {
                                System.out.println("Player two has folded, player one wins!");
                            } else if (bcf.equals("call")) {
                                bet2 = 3;
                                System.out.println("Player two calls, the pot is now " + (bet1 + bet2));
                                players.makeTurn();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 4;
                                    System.out.println("Player one bet, would player two like to raise, call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("raise")) {
                                        bet2 = 5;
                                        System.out.println("Player two raises, would player one like to call or fold");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 5;
                                            System.out.println("Player one calls, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 6;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 7;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 7;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one folds, player two wins!");
                                        }

                                    } else if (bcf.equals("call")) {
                                        bet2 = 4;
                                        System.out.println("Player two calls, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 5;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 6;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 5;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two folds, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one checks, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 4;
                                        System.out.println("Player two bets, would player one like to raise, call, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("raise")) {
                                            bet1 = 5;
                                            System.out.println("Player one raises, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two calls, the pot is now " + (bet1 + bet2));
                                                players.makeRiver();
                                                System.out.println("Would player one like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet2 = 7;
                                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet1 = 7;
                                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player one has folded, player two wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("bet")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet1 = 6;
                                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("raise")) {
                                                            bet1 = 7;
                                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                                            bcf = scnr.next();
                                                            if (bcf.equals("call")) {
                                                                bet2 = 7;
                                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                            } else if (bcf.equals("fold")) {
                                                                System.out.println("Player two has folded, player one wins!");
                                                            }
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player one has folded, player two wins!");
                                                        }
                                                    } else if (bcf.equals("check")) {
                                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    }
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two folds, player one wins!");
                                            }
                                        } else if (bcf.equals("call")) {
                                            bet1 = 4;
                                            System.out.println("Player one calls, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 5;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 5;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 6;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one folds, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two checks, the pot is still " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 4;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 5;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 4;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 4;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 5;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            } else if (bcf.equals("raise")) {
                System.out.println("Player two has raised, would player one like to call or fold?");
                bcf = scnr.next();
                if (bcf.equals("call")) {
                    bet1 = 2;
                    bet2 = 2;
                    System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                    players.makeFlop();
                    System.out.println("Would player one like to check or bet?");
                    bcf = scnr.next();
                    if (bcf.equals("check")) {
                        System.out.println("Player one checks, would player two like to check or bet?");
                        bcf = scnr.next();
                        if (bcf.equals("check")) {
                            System.out.println("Player two checks, the pot is still " + (bet1 + bet2));
                            players.makeTurn();
                            System.out.println("Would player one like to bet or check?");
                            bcf = scnr.next();
                            if (bcf.equals("bet")) {
                                bet1 = 3;
                                System.out.println("Player one bets, would player two like to call, raise, or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet2 = 3;
                                    System.out.println("Player two calls, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 4;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 5;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 4;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 5;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("raise")) {
                                    bet2 = 4;
                                    System.out.println("Player two raises, would player one like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 4;
                                        System.out.println("Player one calls, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 5;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 6;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 5;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one folds, player two wins!");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player two folds, player one wins!");
                                }
                            } else if (bcf.equals("check")) {
                                System.out.println("Player one checks, would player two like to check or bet?");
                                bcf = scnr.next();
                                if (bcf.equals("check")) {
                                    System.out.println("Player two checks, the pot is still " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 3;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 3;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 4;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 3;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 3;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 4;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 4;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("bet")) {
                                    bet2 = 3;
                                    System.out.println("Player two bets, would player one like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 3;
                                        System.out.println("Player one calls, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 4;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 5;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 4;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 4;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 5;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("raise")) {
                                        bet1 = 4;
                                        System.out.println("Player one raises, would player two like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two calls, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 5;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 5;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 6;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two folds, player one wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one folds, player two wins!");
                                    }
                                }
                            }
                        }
                        if (bcf.equals("bet")) {
                            bet2 = 3;
                            System.out.println("Player two bets, would player one like to fold, call, or raise?");
                            bcf = scnr.next();
                            if (bcf.equals("fold")) {
                                System.out.println("Player one has folded, player two wins!");
                            } else if (bcf.equals("call")) {
                                bet1 = 3;
                                System.out.println("Player one calls, the pot is now " + (bet1 + bet2));
                                players.makeTurn();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 4;
                                    System.out.println("Player one bets, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 4;
                                        System.out.println("Player two calls, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 5;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 6;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 5;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 5;
                                        System.out.println("Player two raises, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 5;
                                            System.out.println("Player one calls, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 6;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 7;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 7;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two folds, player one wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one folds, player two wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one checks, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 4;
                                        System.out.println("Player two bets, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 4;
                                            System.out.println("Player one calls, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 5;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 5;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 6;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 5;
                                            System.out.println("Player one raises, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two calls, the pot is now " + (bet1 + bet2));
                                                players.makeRiver();
                                                System.out.println("Would player one like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet2 = 7;
                                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet1 = 7;
                                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player one has folded, player two wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("bet")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet1 = 6;
                                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("raise")) {
                                                            bet1 = 7;
                                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                                            bcf = scnr.next();
                                                            if (bcf.equals("call")) {
                                                                bet2 = 7;
                                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                            } else if (bcf.equals("fold")) {
                                                                System.out.println("Player two has folded, player one wins!");
                                                            }
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player one has folded, player two wins!");
                                                        }
                                                    } else if (bcf.equals("check")) {
                                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    }
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two folds, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one folds, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two checks, the pot is still " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 4;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 5;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 4;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 4;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 5;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    }
                                }
                            }
                            //LEFT OFF HERE
                            else if (bcf.equals("raise")) {
                                bet1 = 4;
                                System.out.println("Player one raises, would player two like to call or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet2 = 4;
                                    System.out.println("Player two calls, the pot is now " + (bet1 + bet2));
                                    players.makeTurn();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 5;
                                        System.out.println("Player one bets, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 5;
                                            System.out.println("Player two calls, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 6;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 7;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 7;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 6;
                                            System.out.println("Player two raises, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 6;
                                                System.out.println("Player one calls, the pot is now " + (bet1 + bet2));
                                                players.makeRiver();
                                                System.out.println("Would player one like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet1 = 7;
                                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 7;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet2 = 8;
                                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet1 = 8;
                                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player one has folded, player two wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("bet")) {
                                                        bet2 = 7;
                                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet1 = 7;
                                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("raise")) {
                                                            bet1 = 8;
                                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                                            bcf = scnr.next();
                                                            if (bcf.equals("call")) {
                                                                bet2 = 8;
                                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                            } else if (bcf.equals("fold")) {
                                                                System.out.println("Player two has folded, player one wins!");
                                                            }
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player one has folded, player two wins!");
                                                        }
                                                    } else if (bcf.equals("check")) {
                                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    }
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one folds, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two folds, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two checks, the pot is still " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 5;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 6;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 5;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player two folds, player one wins!");
                                }
                            }
                        }
                    } else if (bcf.equals("bet")) {
                        bet1 = 5;
                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                        bcf = scnr.next();
                        if (bcf.equals("fold")) {
                            System.out.println("player two has folded, player one wins!");
                        } else if (bcf.equals("call")) {
                            bet2 = 5;
                            System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                            players.makeTurn();
                            System.out.println("Would player one check or bet?");
                            bcf = scnr.next();
                            if (bcf.equals("check")) {
                                System.out.println("Player one checks, does player two want to check or bet?");
                                bcf = scnr.next();
                                if (bcf.equals("check")) {
                                    System.out.println("Player two checks, the pot is still " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 6;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 6;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 7;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 7;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 6;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 6;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 7;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 7;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("bet")) {
                                    bet2 = 6;
                                    System.out.println("Player two bets, does player one want to call, fold, or raise?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 6;
                                        System.out.println("Player one calls, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 7;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 7;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 8;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 8;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 4;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 4;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 5;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one folds, player two wins!");
                                    } else if (bcf.equals("raise")) {
                                        bet1 = 7;
                                        System.out.println("Player one raises, would player two like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 7;
                                            System.out.println("Player two calls, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 8;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 8;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 9;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 9;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 8;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 8;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 9;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 9;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two folds, player one wins!");
                                        }
                                    }
                                }
                            } else if (bcf.equals("bet")) {
                                bet1 = 6;
                                System.out.println("Player one bets, would player two like to call, raise, or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet2 = 6;
                                    System.out.println("Player two calls, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 7;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 7;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 8;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 8;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 7;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 7;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 8;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 8;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("raise")) {
                                    bet2 = 7;
                                    System.out.println("Player two raises, would player one like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 7;
                                        System.out.println("Player two calls, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 8;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 8;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 9;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 9;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 8;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 8;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 9;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 9;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one folds, player two wins!");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player two folds, player one wins!");
                                }
                            }
                        } else if (bcf.equals("raise")) {
                            bet2 = 6;
                            System.out.println("Player two has raised, would player one like to call or fold?");
                            bcf = scnr.next();
                            if (bcf.equals("call")) {
                                bet1 = 6;
                                System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                players.makeTurn();
                                System.out.println("Does player one want to check or bet?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 7;
                                    System.out.println("PLayer one has bet, would player two like to call, fold, or raise?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 7;
                                        System.out.println("Player two has called, the pot  is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 8;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 8;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 9;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 9;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 8;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 8;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 9;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 9;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 8;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 8;
                                            System.out.println("Player one calls, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 9;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 9;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 10;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 10;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 9;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 9;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 10;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 10;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one folds, player two wins!");
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (bcf.equals("fold")) {
                    System.out.println("Player one has folded, player two wins!");
                }
            } else if (bcf.equals("fold")) {
                System.out.println("Player two has folded, player one wins!");
            }
        }
    }

    public void Check(){    //Used alongside program class for if player one opts to check as first move, had to separate methods due to code being too long error
        bcf = "check";   //Bcf set to check because program class did not account for this, change was made after code was split into two method.
        if (bcf.equals("check")) {
        System.out.println("Player one has checked, would player two like to bet or check?");
        bcf = scnr.next();
        //Once again goes through every single possibility for what the users could do when it comes to betting, checking, or raising using
            //if and else if statements and the bcf and bet1/bet2 variables to track how much is in the pot and what action the user takes
        if (bcf.equals("check")) {
            System.out.println("Player two checks, the pot is 0.");
            players.makeFlop();
            System.out.println("Would player one like to bet or check?");
            bcf = scnr.next();
            if (bcf.equals("check")) {
                System.out.println("Player one has checked, would player two like to bet or check?");
                bcf = scnr.next();
                if (bcf.equals("check")) {
                    System.out.println("Player two has checked, the pot is still 0.");
                    players.makeTurn();
                    System.out.println("Would player two like to bet or check?");
                    bcf = scnr.next();
                    if (bcf.equals("bet")) {
                        bet1 = 1;
                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                        bcf = scnr.next();
                        if (bcf.equals("call")) {
                            bet2 = 1;
                            System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                            players.makeRiver();
                            System.out.println("Would player one like to bet or check?");
                            bcf = scnr.next();
                            if (bcf.equals("bet")) {
                                bet1 = 2;
                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet2 = 2;
                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                } else if (bcf.equals("raise")) {
                                    bet2 = 3;
                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 3;
                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player two has folded, player one wins!");
                                }
                            } else if (bcf.equals("check")) {
                                System.out.println("Player one has checked, would player two like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet2 = 2;
                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 2;
                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet1 = 3;
                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 3;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                }
                            }
                        } else if (bcf.equals("raise")) {
                            bet2 = 2;
                            System.out.println("Player two has raised, would player one like to call or fold?");
                            bcf = scnr.next();
                            if (bcf.equals("call")) {
                                bet1 = 2;
                                System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                players.makeRiver();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 3;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 3;
                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 4;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 4;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 3;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 3;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 4;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    }
                                }
                            } else if (bcf.equals("fold")) {
                                System.out.println("Player one folds, player two wins!");
                            }
                        } else if (bcf.equals("fold")) {
                            System.out.println("Player two folds, player one wins!");
                        }
                    } else if (bcf.equals("check")) {
                        System.out.println("Player one has checked, would player two like to bet or check?");
                        bcf = scnr.next();
                        if (bcf.equals("bet")) {
                            bet2 = 1;
                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                            bcf = scnr.next();
                            if (bcf.equals("call")) {
                                bet1 = 1;
                                System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                players.makeRiver();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 2;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 2;
                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 3;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 3;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 2;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 2;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 3;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 3;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    }
                                }
                            } else if (bcf.equals("raise")) {
                                bet1 = 2;
                                System.out.println("Player one has raised, would player one like to call or fold?" + (bet1 + bet2));
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet2 = 2;
                                    System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 3;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 3;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 4;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 3;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 3;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 4;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 4;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player two has folded, player one wins!");
                                }
                            } else if (bcf.equals("fold")) {
                                System.out.println("Player one has folded, player one wins!");
                            }
                        } else if (bcf.equals("check")) {
                            System.out.println("Player two has checked, the pot is still 0.");
                            players.makeRiver();
                            System.out.println("Would player one like to bet or check?");
                            bcf = scnr.next();
                            if (bcf.equals("bet")) {
                                bet1 = 1;
                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet2 = 1;
                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                } else if (bcf.equals("raise")) {
                                    bet2 = 2;
                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 2;
                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player two has folded, player one wins!");
                                }
                            } else if (bcf.equals("check")) {
                                System.out.println("Player one has checked, would player two like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet2 = 1;
                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 1;
                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet1 = 2;
                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 2;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                }
                            }
                        }

                    }
                }
                if (bcf.equals("bet")) {
                    System.out.println("Player two bets, would player one like to call, fold, or raise?");
                    bcf = scnr.next();
                    bet2 = 1;
                    if (bcf.equals("call")) {
                        bet1 = 1;
                        System.out.println("Player one calls, the pot is now " + (bet1 + bet2));
                        players.makeTurn();
                        System.out.println("Would player one like to bet or check?");
                        bcf = scnr.next();
                        if (bcf.equals("bet")) {
                            bet1 = 2;
                            System.out.println("Player one has bet, would player two like to call, raise, or fold");
                            bcf = scnr.next();
                            if (bcf.equals("call")) {
                                bet2 = 2;
                                System.out.println("Player two calls, the pot is now " + (bet1 + bet2));
                                players.makeRiver();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 3;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 3;
                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 4;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 4;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 3;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 3;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 4;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    }
                                }
                            } else if (bcf.equals("raise")) {
                                bet2 = 3;
                                System.out.println("Player two has raised, would player one like to call or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet1 = 3;
                                    System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 4;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 5;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 4;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 5;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player one has folded, player two wins!");
                                }
                            } else if (bcf.equals("fold")) {
                                System.out.println("Player two has folded, player one wins!");
                            }
                        } else if (bcf.equals("check")) {
                            System.out.println("Player one has checked, would player two like to bet or check?");
                            bcf = scnr.next();
                            if (bcf.equals("bet")) {
                                bet2 = 2;
                                System.out.println("Player two has bet, would player one like to call, raise or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet1 = 2;
                                    System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 3;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 3;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 4;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 3;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 3;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 4;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 4;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("raise")) {
                                    bet1 = 3;
                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 3;
                                        System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 4;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 5;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 4;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 4;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 5;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player one has folded, player two wins!");
                                }
                            } else if (bcf.equals("check")) {
                                System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                players.makeRiver();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 2;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 2;
                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 3;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 3;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 2;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 2;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 3;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 3;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    }
                                }
                            }
                        }
                    }
                    if (bcf.equals("raise")) {
                        bet1 = 2;
                        System.out.println("Player one raises, would player two like to call or fold?");
                        bcf = scnr.next();
                        if (bcf.equals("fold")) {
                            System.out.println("Player two has folded, player one wins!");
                        }
                        if (bcf.equals("call")) {
                            bet2 = 2;
                            System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                            players.makeTurn();
                            System.out.println("Would player one like to check or bet");
                            bcf = scnr.next();
                            if (bcf.equals("check")) {
                                System.out.println("Player one has checked, would player two like to check or bet?");
                                bcf = scnr.next();
                                if (bcf.equals("check")) {
                                    System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 3;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 3;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 4;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 3;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 3;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 4;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 4;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("bet")) {
                                    bet2 = 3;
                                    System.out.println("Player two has bet, would player one like to raise, call, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("raise")) {
                                        bet1 = 4;
                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 5;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 5;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 6;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("call")) {
                                        bet1 = 3;
                                        System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 4;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 5;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 4;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 4;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 5;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                }
                            } else if (bcf.equals("bet")) {
                                bet1 = 3;
                                System.out.println("Player one has bet, would player two like to call, fold, or raise?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet2 = 3;
                                    System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 4;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 5;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 4;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 5;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player two has folded, player one wins!");
                                } else if (bcf.equals("raise")) {
                                    bet2 = 4;
                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 4;
                                        System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 5;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 6;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 5;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                }

                            }
                        }
                    }
                }
            } else if (bcf.equals("bet")) {
                bet1 = 1;
                System.out.println("Player one has bet, would player two like to call, fold, or raise?");
                bcf = scnr.next();
                if (bcf.equals("call")) {
                    bet2 = 1;
                    System.out.println("Player two calls, the pot is now " + (bet1 + bet2));
                    players.makeTurn();
                    System.out.println("Would player one like to bet or check?");
                    bcf = scnr.next();
                    if (bcf.equals("bet")) {
                        bet1 = 2;
                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                        bcf = scnr.next();
                        if (bcf.equals("call")) {
                            bet2 = 2;
                            System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                            players.makeRiver();
                            System.out.println("Would player one like to bet or check?");
                            bcf = scnr.next();
                            if (bcf.equals("bet")) {
                                bet1 = 3;
                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet2 = 3;
                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                } else if (bcf.equals("raise")) {
                                    bet2 = 4;
                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 4;
                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player two has folded, player one wins!");
                                }
                            } else if (bcf.equals("check")) {
                                System.out.println("Player one has checked, would player two like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet2 = 3;
                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 3;
                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet1 = 4;
                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                }
                            }
                        } else if (bcf.equals("raise")) {
                            bet2 = 3;
                            System.out.println("Player two has raised, would player one like to call or fold?");
                            bcf = scnr.next();
                            if (bcf.equals("call")) {
                                bet1 = 3;
                                System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                players.makeRiver();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 4;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 4;
                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 5;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 5;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 4;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 4;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 5;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    }
                                }
                            } else if (bcf.equals("fold")) {
                                System.out.println("Player one has folded, player two wins!");
                            }
                        } else if (bcf.equals("fold")) {
                            System.out.println("Player two has folded, player one wins!");
                        }
                    } else if (bcf.equals("check")) {
                        System.out.println("Player one has checked, would player two like to check or bet?");
                        bcf = scnr.next();
                        if (bcf.equals("check")) {
                            System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                            players.makeRiver();
                            System.out.println("Would player one like to bet or check?");
                            bcf = scnr.next();
                            if (bcf.equals("bet")) {
                                bet1 = 2;
                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet2 = 2;
                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                } else if (bcf.equals("raise")) {
                                    bet2 = 3;
                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 3;
                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player two has folded, player one wins!");
                                }
                            } else if (bcf.equals("check")) {
                                System.out.println("Player one has checked, would player two like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet2 = 2;
                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 2;
                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet1 = 3;
                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 3;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                }
                            }
                        } else if (bcf.equals("bet")) {
                            bet2 = 2;
                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                            bcf = scnr.next();
                            if (bcf.equals("call")) {
                                bet1 = 2;
                                System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                players.makeRiver();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 3;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 3;
                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 4;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 4;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 3;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 3;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 4;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    }
                                }
                            } else if (bcf.equals("raise")) {
                                bet1 = 3;
                                System.out.println("Player one has raised, would player two like to call or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet2 = 3;
                                    System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 4;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 5;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 4;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 5;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player two has folded, player one wins!");
                                }
                            } else if (bcf.equals("fold")) {
                                System.out.println("Player one has folded, player two wins!");
                            }
                        }
                    }
                } else if (bcf.equals("raise")) {

                    System.out.println("Player two has raised, would player one like to call or fold?");
                    bcf = scnr.next();
                    bet2 = 2;
                    if (bcf.equals("fold")) {
                        System.out.println("Player one has folded, player two wins!");
                    } else if (bcf.equals("call")) {
                        bet1 = 2;
                        System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                        players.makeTurn();
                        System.out.println("Would player one like to bet or check?");
                        bcf = scnr.next();
                        if (bcf.equals("bet")) {
                            bet1 = 3;
                            System.out.println("Player one has bet, would player two like to call, fold, or raise?");
                            bcf = scnr.next();
                            if (bcf.equals("call")) {
                                bet2 = 3;
                                System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                players.makeRiver();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 4;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 4;
                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 5;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 5;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 4;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 4;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 5;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    }
                                }
                            } else if (bcf.equals("fold")) {
                                System.out.println("Player two has folded, player one wins!");
                            } else if (bcf.equals("raise")) {
                                bet2 = 4;
                                System.out.println("Player two has raised, would player one like to call or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet1 = 4;
                                    System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 5;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 5;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 6;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 6;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 5;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 6;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player one has folded, player two wins!");
                                }
                            }
                        } else if (bcf.equals("check")) {
                            System.out.println("Player one has checked, would player two like to bet or check?");
                            bcf = scnr.next();
                            if (bcf.equals("bet")) {
                                bet2 = 3;
                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet1 = 3;
                                    System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 4;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 5;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 4;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 5;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("raise")) {
                                    bet1 = 4;
                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 4;
                                        System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player one has folded, player two wins!");
                                }
                            } else if (bcf.equals("check")) {
                                System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                players.makeRiver();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 3;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 3;
                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 4;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 4;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 3;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 3;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 4;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (bcf.equals("bet")) {
            System.out.println("Player two has bet, would Player one like to fold, call or raise?");
            bet2 = 1;
            bcf = scnr.next();
            if (bcf.equals("fold")) {
                System.out.println("Player one has folded, Player two wins!");
            } else if (bcf.equals("raise")) {
                bet1 = 2;
                System.out.println("Player one has raised, would player two like to call or fold?");
                bcf = scnr.next();
                if (bcf.equals("call")) {
                    bet2 = 2;
                    System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                    players.makeFlop();
                    System.out.println("Would player one like to bet or check?");
                    bcf = scnr.next();
                    if (bcf.equals("check")) {
                        System.out.println("Player one has checked, would player two like to bet or check?");
                        bcf = scnr.next();
                        if (bcf.equals("check")) {
                            System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                            players.makeTurn();
                            System.out.println("Would player one like to bet or check?");
                            bcf = scnr.next();
                            if (bcf.equals("bet")) {
                                bet1 = 3;
                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet2 = 3;
                                    System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 4;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 5;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 4;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 5;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("raise")) {
                                    bet2 = 4;
                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 4;
                                        System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 5;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 6;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 5;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player two has folded, player one wins!");
                                }
                            } else if (bcf.equals("check")) {
                                System.out.println("Player one has checked, would player two like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet2 = 3;
                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 3;
                                        System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 4;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 5;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 4;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 4;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 5;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("raise")) {
                                        bet1 = 4;
                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 5;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 5;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 6;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 3;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 3;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 4;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 3;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 3;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 4;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 4;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                }
                            }
                        } else if (bcf.equals("bet")) {
                            bet2 = 3;
                            System.out.println("Player two has bet, would player one like to raise, call, or fold?");
                            bcf = scnr.next();
                            if (bcf.equals("fold")) {
                                System.out.println("Player one has folded, player two wins!");
                            } else if (bcf.equals("call")) {
                                bet1 = 3;
                                System.out.println("Player one calls, the pot is now " + (bet1 + bet2));
                                players.makeTurn();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 4;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 4;
                                        System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 5;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 6;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 5;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 5;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 5;
                                            System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 6;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 7;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 7;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 4;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 4;
                                            System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 5;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 5;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 6;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 5;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                                players.makeRiver();
                                                System.out.println("Would player one like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet2 = 7;
                                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet1 = 7;
                                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player one has folded, player two wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("bet")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet1 = 6;
                                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("raise")) {
                                                            bet1 = 7;
                                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                                            bcf = scnr.next();
                                                            if (bcf.equals("call")) {
                                                                bet2 = 7;
                                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                            } else if (bcf.equals("fold")) {
                                                                System.out.println("Player two has folded, player one wins!");
                                                            }
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player one has folded, player two wins!");
                                                        }
                                                    } else if (bcf.equals("check")) {
                                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    }
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 4;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 5;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 4;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 4;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 5;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    }
                                }
                            } else if (bcf.equals("raise")) {
                                bet1 = 4;
                                System.out.println("Player one raised, would player two like to call or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("fold")) {
                                    System.out.println("Player two has folded, player one wins!");
                                } else if (bcf.equals("call")) {
                                    bet2 = 4;
                                    System.out.println("Player two calls, the pot is now " + (bet1 + bet2));
                                    players.makeTurn();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 5;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 5;
                                            System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 6;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 7;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 7;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 6;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 6;
                                                System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                                players.makeRiver();
                                                System.out.println("Would player one like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet1 = 7;
                                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 7;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet2 = 8;
                                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet1 = 8;
                                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player one has folded, player two wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("bet")) {
                                                        bet2 = 7;
                                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet1 = 7;
                                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("raise")) {
                                                            bet1 = 8;
                                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                                            bcf = scnr.next();
                                                            if (bcf.equals("call")) {
                                                                bet2 = 8;
                                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                            } else if (bcf.equals("fold")) {
                                                                System.out.println("Player two has folded, player one wins!");
                                                            }
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player one has folded, player two wins!");
                                                        }
                                                    } else if (bcf.equals("check")) {
                                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    }
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 5;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called the pot is now " + (bet1 + bet2));
                                                players.makeRiver();
                                                System.out.println("Would player one like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet2 = 7;
                                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet1 = 7;
                                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player one has folded, player two wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("bet")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet1 = 6;
                                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("raise")) {
                                                            bet1 = 7;
                                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                                            bcf = scnr.next();
                                                            if (bcf.equals("call")) {
                                                                bet2 = 7;
                                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                            } else if (bcf.equals("fold")) {
                                                                System.out.println("Player two has folded, player one wins!");
                                                            }
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player one has folded, player two wins!");
                                                        }
                                                    } else if (bcf.equals("check")) {
                                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    }
                                                }
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 6;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                                    players.makeRiver();
                                                    System.out.println("Would player one like to bet or check?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("bet")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 7;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("raise")) {
                                                            bet2 = 8;
                                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                                            bcf = scnr.next();
                                                            if (bcf.equals("call")) {
                                                                bet1 = 8;
                                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                            } else if (bcf.equals("fold")) {
                                                                System.out.println("Player one has folded, player two wins!");
                                                            }
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("check")) {
                                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("bet")) {
                                                            bet2 = 7;
                                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                            bcf = scnr.next();
                                                            if (bcf.equals("call")) {
                                                                bet1 = 7;
                                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                            } else if (bcf.equals("raise")) {
                                                                bet1 = 8;
                                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                                bcf = scnr.next();
                                                                if (bcf.equals("call")) {
                                                                    bet2 = 8;
                                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                                } else if (bcf.equals("fold")) {
                                                                    System.out.println("Player two has folded, player one wins!");
                                                                }
                                                            } else if (bcf.equals("fold")) {
                                                                System.out.println("Player one has folded, player two wins!");
                                                            }
                                                        } else if (bcf.equals("check")) {
                                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        }
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 5;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 5;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 6;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if (bcf.equals("bet")) {
                        bet1 = 3;
                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                        bcf = scnr.next();
                        if (bcf.equals("fold")) {
                            System.out.println("Player two has folded, player one wins!");
                        } else if (bcf.equals("call")) {
                            bet2 = 3;
                            System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                            players.makeTurn();
                            System.out.println("Would player one like to bet or check?");
                            bcf = scnr.next();
                            if (bcf.equals("bet")) {
                                bet1 = 4;
                                System.out.println("Player one has bet, would player two like to call, raise or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet2 = 4;
                                    System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 5;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 5;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 6;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 6;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 5;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 6;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("raise")) {
                                    bet2 = 5;
                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 5;
                                        System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 6;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 6;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 7;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 7;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 6;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 7;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 7;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player two has folded, player one wins!");
                                }
                            } else if (bcf.equals("check")) {
                                System.out.println("Player one has checked, would player two like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet2 = 4;
                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 4;
                                        System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 5;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 6;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 5;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("raise")) {
                                        bet1 = 5;
                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 5;
                                            System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 6;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 7;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 7;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 4;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 5;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 4;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 5;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                }
                            }
                        } else if (bcf.equals("raise")) {
                            bet2 = 4;
                            System.out.println("Player two has raised, would player one like to call or fold?");
                            bcf = scnr.next();
                            if (bcf.equals("fold")) {
                                System.out.println("Player one has folded, player two wins!");
                            } else if (bcf.equals("call")) {
                                bet1 = 4;
                                System.out.println("Player one calls, the pot is now " + (bet2 + bet1));
                                players.makeTurn();
                                System.out.println("Player one, bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 5;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 5;
                                        System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 6;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 6;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 7;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 7;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 6;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 7;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 7;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 6;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 6;
                                            System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 7;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 7;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 8;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 8;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 7;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 8;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 8;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 5;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 5;
                                            System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 6;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 7;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 7;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 6;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 6;
                                                System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                                players.makeRiver();
                                                System.out.println("Would player one like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet1 = 7;
                                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 7;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet2 = 8;
                                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet1 = 8;
                                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player one has folded, player two wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("bet")) {
                                                        bet2 = 7;
                                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet1 = 7;
                                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("raise")) {
                                                            bet1 = 8;
                                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                                            bcf = scnr.next();
                                                            if (bcf.equals("call")) {
                                                                bet2 = 8;
                                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                            } else if (bcf.equals("fold")) {
                                                                System.out.println("Player two has folded, player one wins!");
                                                            }
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player one has folded, player two wins!");
                                                        }
                                                    } else if (bcf.equals("check")) {
                                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    }
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 5;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 6;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 5;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (bcf.equals("fold")) {
                    System.out.println("Player two has folded, player one wins!");
                }
            } else if (bcf.equals("call")) {
                bet1 = 1;
                System.out.println("Player one calls, the pot is now" + (bet1 + bet2));
                players.makeFlop();
                System.out.println("Would player one like to check or bet?");
                bcf = scnr.next();
                if (bcf.equals("check")) {
                    System.out.println("Player one has checked, would player two like to check or bet?");
                    bcf = scnr.next();
                    if (bcf.equals("check")) {
                        System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                        players.makeTurn();
                        System.out.println("Would player one like to bet or check?");
                        bcf = scnr.next();
                        if (bcf.equals("bet")) {
                            bet1 = 2;
                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                            bcf = scnr.next();
                            if (bcf.equals("call")) {
                                bet2 = 2;
                                System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                players.makeRiver();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 3;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 3;
                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 4;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 4;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 3;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 3;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 4;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    }
                                }
                            } else if (bcf.equals("raise")) {
                                bet2 = 3;
                                System.out.println("Player two has raised, would player one like to call or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet1 = 3;
                                    System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 4;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 5;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 4;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 5;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player one has folded, player two wins!");
                                }
                            } else if (bcf.equals("fold")) {
                                System.out.println("Player two has folded, player one wins!");
                            }
                        } else if (bcf.equals("check")) {
                            System.out.println("Player one has checked, would player two like to bet or check?");
                            bcf = scnr.next();
                            if (bcf.equals("bet")) {
                                bet2 = 2;
                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet1 = 2;
                                    System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 3;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 3;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 4;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 3;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 3;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 4;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 4;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("raise")) {
                                    bet1 = 3;
                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 3;
                                        System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 4;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 5;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 4;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 4;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 5;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player one has folded, player two wins!");
                                }
                            } else if (bcf.equals("check")) {
                                System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                players.makeRiver();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 2;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 2;
                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 3;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 3;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 2;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 2;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 3;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 3;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    }
                                }
                            }
                        }
                    } else if (bcf.equals("bet")) {
                        bet2 = 2;
                        System.out.println("Player two has bet, would player one like to raise, call, or fold?");
                        bcf = scnr.next();
                        if (bcf.equals("call")) {
                            bet1 = 2;
                            System.out.println("Player one calls, the pot is now " + (bet1 + bet2));
                            players.makeTurn();
                            System.out.println("Would player one like to bet or check?");
                            bcf = scnr.next();
                            if (bcf.equals("bet")) {
                                bet1 = 3;
                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet2 = 3;
                                    System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 4;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 5;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 4;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 5;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("raise")) {
                                    bet2 = 4;
                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 4;
                                        System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 5;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 6;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 5;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player two has folded, player one wins!");
                                }
                            } else if (bcf.equals("check")) {
                                System.out.println("Player one has checked, would player two like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet2 = 3;
                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 3;
                                        System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 4;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 5;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 4;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 4;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 5;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("raise")) {
                                        bet1 = 4;
                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 5;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 5;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 6;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 3;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 3;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 4;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 3;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 3;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 4;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 4;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                }
                            }
                        } else if (bcf.equals("fold")) {
                            System.out.println("Player one folds, player two wins!");
                        } else if (bcf.equals("raise")) {
                            bet1 = 3;
                            System.out.println("Player one raises, would player two like to call or fold?");
                            bcf = scnr.next();
                            if (bcf.equals("fold")) {
                                System.out.println("Player two folds, player one wins!");
                            } else if (bcf.equals("call")) {
                                bet2 = 3;
                                System.out.println("Player two calls, the pot is now " + (bet1 + bet2));
                                players.makeTurn();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 4;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 4;
                                        System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 5;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 6;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 5;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 5;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 5;
                                            System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 6;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 7;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 7;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to check or bet?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 4;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 4;
                                            System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 5;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 5;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 6;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("raised")) {
                                            bet1 = 5;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                                players.makeRiver();
                                                System.out.println("Would player one like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet2 = 7;
                                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet1 = 7;
                                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player one has folded, player two wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("bet")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet1 = 6;
                                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("raise")) {
                                                            bet1 = 7;
                                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                                            bcf = scnr.next();
                                                            if (bcf.equals("call")) {
                                                                bet2 = 7;
                                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                            } else if (bcf.equals("fold")) {
                                                                System.out.println("Player two has folded, player one wins!");
                                                            }
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player one has folded, player two wins!");
                                                        }
                                                    } else if (bcf.equals("check")) {
                                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    }
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 4;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 5;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 4;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 4;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 5;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (bcf.equals("bet")) {
                    bet1 = 2;
                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                    bcf = scnr.next();
                    if (bcf.equals("call")) {
                        bet2 = 2;
                        System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                        players.makeTurn();
                        System.out.println("Would player one like to bet or check?");
                        bcf = scnr.next();
                        if (bcf.equals("bet")) {
                            bet1 = 3;
                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                            bcf = scnr.next();
                            if (bcf.equals("call")) {
                                bet2 = 3;
                                System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                players.makeRiver();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 4;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 4;
                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 5;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 5;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 4;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 4;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 5;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    }
                                }
                            } else if (bcf.equals("raise")) {
                                bet2 = 4;
                                System.out.println("Player two has raised, would player one like to call or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet1 = 4;
                                    System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 5;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 5;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 6;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 6;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 5;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 6;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player one has folded, player two wins!");
                                }
                            } else if (bcf.equals("fold")) {
                                System.out.println("Player two has folded, player one wins!");
                            }
                        } else if (bcf.equals("check")) {
                            System.out.println("Player one has checked, would player two like to bet or check?");
                            bcf = scnr.next();
                            if (bcf.equals("bet")) {
                                bet2 = 3;
                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet1 = 3;
                                    System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 4;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 5;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 4;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 5;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("raise")) {
                                    bet1 = 4;
                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 4;
                                        System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 5;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 6;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 5;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player one has folded, player two wins!");
                                }
                            } else if (bcf.equals("check")) {
                                System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                players.makeRiver();
                                System.out.println("Would player one like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet1 = 3;
                                    System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet2 = 3;
                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    } else if (bcf.equals("raise")) {
                                        bet2 = 4;
                                        System.out.println("Player two has raised, would player one like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 4;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player two has folded, player one wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player one has checked, would player two like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet2 = 3;
                                        System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet1 = 3;
                                            System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet1 = 4;
                                            System.out.println("Player one has raised, would player two like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 4;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player one has folded, player two wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                    }
                                }
                            }
                        }
                    } else if (bcf.equals("fold")) {
                        System.out.println("Player two folds, player one wins!");
                    } else if (bcf.equals("raise")) {
                        bet2 = 3;
                        System.out.println("Player two raises, would player one like to call or fold?");
                        bcf = scnr.next();
                        if (bcf.equals("fold")) {
                            System.out.println("Player one folds, player two wins!");
                        } else if (bcf.equals("call")) {
                            bet1 = 3;
                            System.out.println("Player one calls, the pot is now " + (bet1 + bet2));
                            players.makeTurn();
                            System.out.println("Would player one like to call or bet or check?");
                            bcf = scnr.next();
                            if (bcf.equals("bet")) {
                                bet1 = 4;
                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                bcf = scnr.next();
                                if (bcf.equals("call")) {
                                    bet2 = 4;
                                    System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 5;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 5;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 6;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 6;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 5;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 6;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                } else if (bcf.equals("raise")) {
                                    bet2 = 5;
                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 5;
                                        System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 6;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 6;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 7;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 7;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 6;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 7;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 7;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("Player one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("fold")) {
                                    System.out.println("Player two has folded, player one wins!");
                                }
                            } else if (bcf.equals("check")) {
                                System.out.println("Player one has checked, would player two like to bet or check?");
                                bcf = scnr.next();
                                if (bcf.equals("bet")) {
                                    bet2 = 4;
                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                    bcf = scnr.next();
                                    if (bcf.equals("call")) {
                                        bet1 = 4;
                                        System.out.println("Player one has called, the pot is now " + (bet1 + bet2));
                                        players.makeRiver();
                                        System.out.println("Would player one like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet1 = 5;
                                            System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet2 = 5;
                                                System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet2 = 6;
                                                System.out.println("Player two has raised, would player one like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player two has folded, player one wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player one has checked, would player two like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet2 = 5;
                                                System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet1 = 5;
                                                    System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet1 = 6;
                                                    System.out.println("Player one has raised, would player two like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet2 = 6;
                                                        System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player two has folded, player one wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player one has folded, player two wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            }
                                        }
                                    } else if (bcf.equals("raise")) {
                                        bet1 = 5;
                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 5;
                                            System.out.println("Player two has called, the pot is now " + (bet1 + bet2));
                                            players.makeRiver();
                                            System.out.println("Would player one like to bet or check?");
                                            bcf = scnr.next();
                                            if (bcf.equals("bet")) {
                                                bet1 = 6;
                                                System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("raise")) {
                                                    bet2 = 7;
                                                    System.out.println("Player two has raised, would player one like to call or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("check")) {
                                                System.out.println("Player one has checked, would player two like to bet or check?");
                                                bcf = scnr.next();
                                                if (bcf.equals("bet")) {
                                                    bet2 = 6;
                                                    System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                                    bcf = scnr.next();
                                                    if (bcf.equals("call")) {
                                                        bet1 = 6;
                                                        System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                    } else if (bcf.equals("raise")) {
                                                        bet1 = 7;
                                                        System.out.println("Player one has raised, would player two like to call or fold?");
                                                        bcf = scnr.next();
                                                        if (bcf.equals("call")) {
                                                            bet2 = 7;
                                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                        } else if (bcf.equals("fold")) {
                                                            System.out.println("Player two has folded, player one wins!");
                                                        }
                                                    } else if (bcf.equals("fold")) {
                                                        System.out.println("Player one has folded, player two wins!");
                                                    }
                                                } else if (bcf.equals("check")) {
                                                    System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                }
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("fold")) {
                                        System.out.println("PLayer one has folded, player two wins!");
                                    }
                                } else if (bcf.equals("check")) {
                                    System.out.println("Player two has checked, the pot is still " + (bet1 + bet2));
                                    players.makeRiver();
                                    System.out.println("Would player one like to bet or check?");
                                    bcf = scnr.next();
                                    if (bcf.equals("bet")) {
                                        bet1 = 4;
                                        System.out.println("Player one has bet, would player two like to call, raise, or fold?");
                                        bcf = scnr.next();
                                        if (bcf.equals("call")) {
                                            bet2 = 4;
                                            System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        } else if (bcf.equals("raise")) {
                                            bet2 = 5;
                                            System.out.println("Player two has raised, would player one like to call or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 5;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");

                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("fold")) {
                                            System.out.println("Player two has folded, player one wins!");
                                        }
                                    } else if (bcf.equals("check")) {
                                        System.out.println("Player one has checked, would player two like to bet or check?");
                                        bcf = scnr.next();
                                        if (bcf.equals("bet")) {
                                            bet2 = 4;
                                            System.out.println("Player two has bet, would player one like to call, raise, or fold?");
                                            bcf = scnr.next();
                                            if (bcf.equals("call")) {
                                                bet1 = 4;
                                                System.out.println("Player one has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                            } else if (bcf.equals("raise")) {
                                                bet1 = 5;
                                                System.out.println("Player one has raised, would player two like to call or fold?");
                                                bcf = scnr.next();
                                                if (bcf.equals("call")) {
                                                    bet2 = 5;
                                                    System.out.println("Player two has called, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                                } else if (bcf.equals("fold")) {
                                                    System.out.println("Player two has folded, player one wins!");
                                                }
                                            } else if (bcf.equals("fold")) {
                                                System.out.println("Player one has folded, player two wins!");
                                            }
                                        } else if (bcf.equals("check")) {
                                            System.out.println("Player two has checked, now compare hands to see who won the pot of " + (bet1 + bet2) + "!");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    }





    //}





    public static void main(String [] args){



    }



}
