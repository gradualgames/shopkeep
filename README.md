# Shopkeep

Shopkeep is a lightweight Discord bot for running old-school tabletop RPGs in play-by-post (PBP) campaigns.

Rather than trying to automate every rule, Shopkeep focuses on one job: keeping character sheets organized and easy to update from Discord. Character data is stored as human-readable JSON files, making it simple to back up, edit by hand, or migrate between servers.

The project is intentionally simple:

* Java 21
* JDA (Java Discord API)
* Jackson
* JSON file storage
* No database
* One JSON file per character

## Features

### Character Management

* Create characters
* Update character statistics
* Select ("play") a character for the current campaign
* Export character JSON files for backup

### Character Information

View all or part of a character sheet:

* Character sheet
* Health & Armor Class
* Saving Throws
* Special Abilities
* Equipment
* Weapons
* Spells
* Prepared spell summary

### Character Editing

Update a character directly from Discord:

* Add special abilities
* Add saving throws
* Add equipment
* Add weapons
* Add spells
* Prepare spells
* Clear prepared spells

## Storage

Character data is stored as plain JSON files.

```text
DATA_DIR/
└── <guild-id>/
    └── <campaign-name>/
        ├── character/
        │   ├── Alice.json
        │   └── Borin.json
        └── players.json
```

Each character is stored in its own JSON file.

`players.json` maps Discord user IDs to the character they are currently playing within a campaign.

## Campaigns

Each Discord text channel is treated as a separate campaign.

For example:

```text
#keep-on-the-borderlands
#stonehell
#dolmenwood
```

Players can use the same Discord server for multiple campaigns while keeping separate character selections for each one.

## Running

Shopkeep expects the following environment variables:

| Variable        | Description                           |
| --------------- | ------------------------------------- |
| `DISCORD_TOKEN` | Discord bot token                     |
| `SERVER_ID`     | Discord server (guild) ID             |
| `DATA_DIR`      | Directory used for persistent storage |

Example:

```bash
export DISCORD_TOKEN=your-token
export SERVER_ID=123456789012345678
export DATA_DIR=/data

./gradlew run
```

## Commands

### Character

```text
/create
/update
/play
/export
/sheet
```

### Information

```text
/health
/saving-throws
/abilities
/spells
/spell-slots
/equipment
/weapons
```

### Editing

```text
/add-ability
/add-saving-throw
/add-equipment
/add-weapon
/add-spell
/prepare-spell
/unprepare-spells
```

## Philosophy

Shopkeep is intentionally small.

Instead of becoming a full virtual tabletop or implementing every rule of every RPG system, it provides a persistent character sheet that players and referees can update quickly during play.

Using plain JSON files keeps the data easy to inspect, back up, edit manually, and migrate as the project evolves. The goal is to make bookkeeping easier without getting in the way of actually playing the game.
