#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <time.h>
#include "dominion.h"
#include "dominion_helpers.h"
#include "rngs.h"

#define TEST_COUNT 1000

//Custom Assert Function
void assertTrue(int a, int b, char* testName)
{
	if(a != b)
	{
		printf("%s Test Failed\n", testName);
	}
}

int main(int argc, char *argv[])
{
	//Print which test is being run
	printf("Random Test - Adventurer\n");
	
	//Declare some variables
	srand(time(0));
	int t, i, r;
	
	for(t = 0; t < TEST_COUNT; t++)
	{	
		//Values to initiate game
		struct gameState state;	
		int numPlayers = rand() % 3 + 2; //random number between 2 and 4
		int kingdom[10];
	
		for(i = 0; i < 10; i++)
		{
			if (i == 0)
				kingdom[i] = adventurer;
				
			else if(i == 1 && r == 0)
				kingdom[i] = curse;
			
			else if(i == 1 && r == 1)
				kingdom[i] = council_room;
				
			else if(i == 2 && r == 0)
				kingdom[i] = feast;
				
			else if(i == 2 && r == 1)
				kingdom[i] = gardens;
				
			else if(i == 3 && r == 0)
				kingdom[i] = mine;
			
			else if(i == 3 && r == 1)
				kingdom[i] = remodel;
				
			else if(i == 4 && r == 0)
				kingdom[i] = smithy;
				
			else if(i == 4 && r == 1)
				kingdom[i] = village;
				
			else if(i == 5 && r == 0)
				kingdom[i] = baron;
				
			else if(i == 5 && r == 1)
				kingdom[i] = great_hall;
				
			else if(i == 6 && r == 0)
				kingdom[i] = minion;
			
			else if(i == 6 && r == 1)
				kingdom[i] = steward;
			
			else if(i == 7 && r == 0)
				kingdom[i] = tribute;
				
			else if(i == 7 && r == 1)
				kingdom[i] = ambassador;
				
			else if(i == 8 && r == 0)
				kingdom[i] = cutpurse;
				
			else if(i == 8 && r == 1)
				kingdom[i] = embargo;
			
			else if(i == 9 && r == 0)
				kingdom[i] = outpost;
			
			else if(i == 9 && r == 1)
				kingdom[i] = salvager;
				
			else if(i == 10 && r == 0)
				kingdom[i] = sea_hag;
				
			else if(i == 10 && r == 1)
				kingdom[i] = treasure_map;
				
			r = rand() % 2;
		}
		
		int seed = rand(); //random number

		//Initiate Game
		int initSuccess = initializeGame(numPlayers, kingdom, seed, &state);
		if(initSuccess != 0)
		{
		   printf("Game failed to initialize\n");
		   printf("Num Players: %d\n", numPlayers);
		   printf("Seed: %d\n", seed);
		}
		
		for(i = 0; i < numPlayers; i++)
		{
			//State of Game Before Card is Played
			int player = whoseTurn(&state);
			int inHand = rand() % MAX_HAND + 1; //if 0 player couldn't play adventurer card so between 1 and max
			state.handCount[player] = inHand;
			int moneyToSpend = state.coins;
			int handpos = rand() % numHandCards(&state); //random hand position
			int bonus = rand();
			int choice1 = rand() % 2; //either true or false
			int choice2 = kingdom[(rand() % 10)]; //get a random kingdom card
			int choice3 = kingdom[(rand() % 10)]; //get a random kingdom card

			int numTreasureCards;
			for(i = 0; i < numHandCards(&state); i++)
			{
				if((state.hand[player][i] == copper) || (state.hand[player][i] == copper) || (state.hand[player][i] == copper))
				{
					numTreasureCards++;
				}
			}
			
			//Play Card
			cardEffect(adventurer, choice1, choice2, choice3, &state, handpos, &bonus);
		   
			//State of Game After Card is Played
			updateCoins(player, &state, bonus);
			int numTreasureCards2;
			for(i = 0; i < numHandCards(&state); i++)
			{
				if((state.hand[player][i] == copper) || (state.hand[player][i] == copper) || (state.hand[player][i] == copper))
				{
					numTreasureCards2++;
				}
			}
			
			//Test Correct Hand Size - Should Have 2 Additional $ Cards
			assertTrue(inHand + 1, numHandCards(&state), "Correct Hand Size -");
			assertTrue(numTreasureCards + 2, numTreasureCards2, "Correct # of Treasure Cards to Spend -");
			
			//Test Correct Amount Money to Spend - Additional $ Should be Available 
			assertTrue(1, (moneyToSpend + 2 <= state.coins), "Correct Amount Money to Spend -");
			
			//Advance to a new players turn
			endTurn(&state);
		}
	}
   
   return 0;   
}