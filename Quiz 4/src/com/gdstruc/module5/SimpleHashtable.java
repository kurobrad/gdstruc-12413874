package com.gdstruc.module5;

public class SimpleHashtable {
    private StoredPlayer[] hashtable;

    public SimpleHashtable()
    {
        hashtable = new StoredPlayer[10];
    }

    private int hashKey(String key)
    {
        return key.length() % hashtable.length;
    }

    public void put(String key, Player value)
    {
        int hashedKey = hashKey(key);
        int originalKey = hashedKey; // store original hash

        // linear probing
        while (hashtable[hashedKey] != null)
        {

            if (hashtable[hashedKey].key.equals(key))
            {
                hashtable[hashedKey].value = value;
                return;
            }

            // moves to next slot
            hashedKey = (hashedKey + 1) % hashtable.length;

            // checks the slots
            if (hashedKey == originalKey)
            {
                System.out.println("Hash table is full!");
                return;
            }
        }

        // if it finds an empty slot, it stores a new one
        hashtable[hashedKey] = new StoredPlayer(key, value);
    }

    public Player get(String key)
    {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
        {
            return null;
        }
        return hashtable[hashedKey].value;
    }


    public Player remove(String key)
    {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
        {
            System.out.println("Key '" + key + "' not found for removal.");
            return null;
        }

        // stores the player before removing it
        Player removedPlayer = hashtable[hashedKey].value;

        hashtable[hashedKey] = new StoredPlayer("remove", null);

        System.out.println("Successfully removed player: " + key);
        return removedPlayer;
    }
    private int findKey(String key)
    {
        int hashedKey = hashKey(key);
        int originalKey = hashedKey;

        while (hashtable[hashedKey] != null)
        {
            if (hashtable[hashedKey].key.equals(key))
            {
                return hashedKey;
            }

            hashedKey = (hashedKey + 1) % hashtable.length;

            // If we've checked all slots
            if (hashedKey == originalKey)
            {
                break;
            }
        }

        return -1;
    }

    private boolean isOccupied(int index)
    {
        return hashtable[index] != null;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            System.out.println("Element " + i + " " + hashtable[i]);
        }
    }
}