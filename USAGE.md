# Usage guide

```bash
# (optional) create and activate a virtual environment
python -m venv .venv && source .venv/bin/activate

# install requirements
pip install -r requirements.txt

# copy & edit config
cp config.example.yml config.yml
#   ↳ edit include/exclude/backup_retention as needed

# dry-run a patch
python scripts/apply_changes.py patches/foo.diff

# real apply + structure update + tests
python scripts/apply_changes.py patches/foo.diff \
       --run --confirm --update-structure --run-tests --verbose
